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

import com.entity.LingjainshebeiEntity;

import com.service.LingjainshebeiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 零件设备表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-24
*/
@RestController
@Controller
@RequestMapping("/lingjainshebei")
public class LingjainshebeiController {
    private static final Logger logger = LoggerFactory.getLogger(LingjainshebeiController.class);

    @Autowired
    private LingjainshebeiService lingjainshebeiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = lingjainshebeiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        LingjainshebeiEntity lingjainshebei = lingjainshebeiService.selectById(id);
        if(lingjainshebei!=null){
            return R.ok().put("data", lingjainshebei);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LingjainshebeiEntity lingjainshebei, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<LingjainshebeiEntity> queryWrapper = new EntityWrapper<LingjainshebeiEntity>()
            .eq("serial", lingjainshebei.getSerial())
            .eq("name", lingjainshebei.getName())
            .eq("lj_types", lingjainshebei.getLjTypes())
            .eq("amount", lingjainshebei.getAmount())
            .eq("production", lingjainshebei.getProduction())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LingjainshebeiEntity lingjainshebeiEntity = lingjainshebeiService.selectOne(queryWrapper);
        if(lingjainshebeiEntity==null){
            lingjainshebeiService.insert(lingjainshebei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LingjainshebeiEntity lingjainshebei, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<LingjainshebeiEntity> queryWrapper = new EntityWrapper<LingjainshebeiEntity>()
            .notIn("id",lingjainshebei.getId())
            .eq("serial", lingjainshebei.getSerial())
            .eq("name", lingjainshebei.getName())
            .eq("lj_types", lingjainshebei.getLjTypes())
            .eq("amount", lingjainshebei.getAmount())
            .eq("production", lingjainshebei.getProduction())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LingjainshebeiEntity lingjainshebeiEntity = lingjainshebeiService.selectOne(queryWrapper);
        if(lingjainshebeiEntity==null){
            lingjainshebeiService.updateById(lingjainshebei);//根据id更新
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
        lingjainshebeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

