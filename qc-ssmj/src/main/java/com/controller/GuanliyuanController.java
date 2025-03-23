package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.annotation.IgnoreAuth;
import com.entity.GuanliyuanEntity;
import com.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.GuanliyuanEntity;

import com.service.GuanliyuanService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 管理员表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-24
*/
@RestController
@Controller
@RequestMapping("/guanliyuan")
public class GuanliyuanController {
    private static final Logger logger = LoggerFactory.getLogger(GuanliyuanController.class);

    @Autowired
    private GuanliyuanService guanliyuanService;


    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(String username, String password, String role, HttpServletRequest request) {
        GuanliyuanEntity user = guanliyuanService.selectOne(new EntityWrapper<GuanliyuanEntity>().eq("account", username));
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
        GuanliyuanEntity user = guanliyuanService.selectById(id);
        return R.ok().put("data", user);
    }


    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody GuanliyuanEntity user){
//    	ValidatorUtils.validateEntity(user);
        if(guanliyuanService.selectOne(new EntityWrapper<GuanliyuanEntity>().eq("account", user.getAccount())) !=null) {
            return R.error("用户已存在");
        }
        guanliyuanService.insert(user);
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
        GuanliyuanEntity user = guanliyuanService.selectOne(new EntityWrapper<GuanliyuanEntity>().eq("account", username));
        if(user==null) {
            return R.error("账号不存在");
        }
        user.setPassword("123456");
        guanliyuanService.update(user,null);
        return R.ok("密码已重置为：123456");
    }
    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = guanliyuanService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        GuanliyuanEntity guanliyuan = guanliyuanService.selectById(id);
        if(guanliyuan!=null){
            return R.ok().put("data", guanliyuan);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GuanliyuanEntity guanliyuan, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<GuanliyuanEntity> queryWrapper = new EntityWrapper<GuanliyuanEntity>()
            .eq("serial", guanliyuan.getSerial())
            .eq("name", guanliyuan.getName())
            .eq("account", guanliyuan.getAccount())
            .eq("password", guanliyuan.getPassword())
            .eq("age", guanliyuan.getAge())
            .eq("sex_types", guanliyuan.getSexTypes())
            .eq("mobile", guanliyuan.getMobile())
            .eq("address", guanliyuan.getAddress())
            .eq("role", guanliyuan.getRole())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuanliyuanEntity guanliyuanEntity = guanliyuanService.selectOne(queryWrapper);
        if(guanliyuanEntity==null){
            guanliyuan.setRole("管理员");
            guanliyuanService.insert(guanliyuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GuanliyuanEntity guanliyuan, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<GuanliyuanEntity> queryWrapper = new EntityWrapper<GuanliyuanEntity>()
            .notIn("id",guanliyuan.getId())
            .eq("serial", guanliyuan.getSerial())
            .eq("name", guanliyuan.getName())
            .eq("account", guanliyuan.getAccount())
            .eq("password", guanliyuan.getPassword())
            .eq("age", guanliyuan.getAge())
            .eq("sex_types", guanliyuan.getSexTypes())
            .eq("mobile", guanliyuan.getMobile())
            .eq("address", guanliyuan.getAddress())
            .eq("role", guanliyuan.getRole())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuanliyuanEntity guanliyuanEntity = guanliyuanService.selectOne(queryWrapper);
        if(guanliyuanEntity==null){
            guanliyuanService.updateById(guanliyuan);//根据id更新
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
        guanliyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

