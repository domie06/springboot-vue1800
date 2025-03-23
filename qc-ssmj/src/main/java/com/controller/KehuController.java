package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.annotation.IgnoreAuth;
import com.entity.KehuEntity;
import com.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.KehuEntity;

import com.service.KehuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 客户信息表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-24
*/
@RestController
@Controller
@RequestMapping("/kehu")
public class KehuController {
    private static final Logger logger = LoggerFactory.getLogger(KehuController.class);

    @Autowired
    private KehuService kehuService;
    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(String username, String password, String role, HttpServletRequest request) {
        KehuEntity user = kehuService.selectOne(new EntityWrapper<KehuEntity>().eq("account", username));
        if(user != null){
            if(!user.getRole().equals(role)){
                return R.error("权限不正常");
            }
            if(user==null || !user.getPassword().equals(password)) {
                return R.error("账号或密码不正确");
            }
            String token = tokenService.generateToken(user.getId(),user.getName(), "users", user.getRole());
            return R.ok().put("token", token);
        }else{
            return R.error("账号或密码或权限不对");
        }

    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        KehuEntity user = kehuService.selectById(id);
        return R.ok().put("data", user);
    }


    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody KehuEntity user){
//    	ValidatorUtils.validateEntity(user);
        if(kehuService.selectOne(new EntityWrapper<KehuEntity>().eq("account", user.getAccount())) !=null) {
            return R.error("用户已存在");
        }
        kehuService.insert(user);
        return R.ok();
    }

    /**
     * 退出
     */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
        KehuEntity user = kehuService.selectOne(new EntityWrapper<KehuEntity>().eq("account", username));
        if(user==null) {
            return R.error("账号不存在");
        }
        user.setPassword("123456");
        kehuService.update(user,null);
        return R.ok("密码已重置为：123456");
    }

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;
        if(role.equals("客户")){
            params.put("yh",request.getSession().getAttribute("userId"));
            page = kehuService.queryPage(params);
        }else{
            page = kehuService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        KehuEntity kehu = kehuService.selectById(id);
        if(kehu!=null){
            return R.ok().put("data", kehu);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KehuEntity kehu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<KehuEntity> queryWrapper = new EntityWrapper<KehuEntity>()
            .eq("serial", kehu.getSerial())
            .eq("name", kehu.getName())
            .eq("account", kehu.getAccount())
            .eq("password", kehu.getPassword())
            .eq("age", kehu.getAge())
            .eq("sex_types", kehu.getSexTypes())
            .eq("mobile", kehu.getMobile())
            .eq("role", kehu.getRole())
            .eq("information", kehu.getInformation())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KehuEntity kehuEntity = kehuService.selectOne(queryWrapper);
        if(kehuEntity==null){
            kehu.setRole("客户");
            kehuService.insert(kehu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KehuEntity kehu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<KehuEntity> queryWrapper = new EntityWrapper<KehuEntity>()
            .notIn("id",kehu.getId())
            .eq("serial", kehu.getSerial())
            .eq("name", kehu.getName())
            .eq("account", kehu.getAccount())
            .eq("password", kehu.getPassword())
            .eq("age", kehu.getAge())
            .eq("sex_types", kehu.getSexTypes())
            .eq("mobile", kehu.getMobile())
            .eq("role", kehu.getRole())
            .eq("information", kehu.getInformation())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KehuEntity kehuEntity = kehuService.selectOne(queryWrapper);
        if(kehuEntity==null){
            kehuService.updateById(kehu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        kehuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

