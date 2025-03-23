package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.WeixiuEntity;

import com.service.WeixiuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 维修信息表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-24
*/
@RestController
@Controller
@RequestMapping("/weixiu")
public class WeixiuController {
    private static final Logger logger = LoggerFactory.getLogger(WeixiuController.class);

    @Autowired
    private WeixiuService weixiuService;

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
            page = weixiuService.queryPage(params);
        }else{
            page = weixiuService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        WeixiuEntity weixiu = weixiuService.selectById(id);
        if(weixiu!=null){
            return R.ok().put("data", weixiu);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiuEntity weixiu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<WeixiuEntity> queryWrapper = new EntityWrapper<WeixiuEntity>()
            .eq("serial_types", weixiu.getSerialTypes())
            .eq("maintenance", weixiu.getMaintenance())
            .eq("ygdate", weixiu.getYgdate())
            .eq("wx_types", weixiu.getWxTypes())
            .eq("pj_types", weixiu.getPjTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiuEntity weixiuEntity = weixiuService.selectOne(queryWrapper);
        if(weixiuEntity==null){
            weixiuService.insert(weixiu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeixiuEntity weixiu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<WeixiuEntity> queryWrapper = new EntityWrapper<WeixiuEntity>()
            .notIn("id",weixiu.getId())
            .eq("serial_types", weixiu.getSerialTypes())
            .eq("maintenance", weixiu.getMaintenance())
            .eq("ygdate", weixiu.getYgdate())
            .eq("wx_types", weixiu.getWxTypes())
            .eq("pj_types", weixiu.getPjTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiuEntity weixiuEntity = weixiuService.selectOne(queryWrapper);
        if(weixiuEntity==null){
            weixiuService.updateById(weixiu);//根据id更新
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
        weixiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

