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

import com.entity.YuangongEntity;

import com.service.YuangongService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 员工表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-24
*/
@RestController
@Controller
@RequestMapping("/yuangong")
public class YuangongController {
    private static final Logger logger = LoggerFactory.getLogger(YuangongController.class);

    @Autowired
    private YuangongService yuangongService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = yuangongService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        YuangongEntity yuangong = yuangongService.selectById(id);
        if(yuangong!=null){
            return R.ok().put("data", yuangong);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongEntity yuangong, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<YuangongEntity> queryWrapper = new EntityWrapper<YuangongEntity>()
            .eq("serial", yuangong.getSerial())
            .eq("name", yuangong.getName())
            .eq("age", yuangong.getAge())
            .eq("sex_types", yuangong.getSexTypes())
            .eq("zc_types", yuangong.getZcTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuangongEntity yuangongEntity = yuangongService.selectOne(queryWrapper);
        if(yuangongEntity==null){
            yuangongService.insert(yuangong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuangongEntity yuangong, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<YuangongEntity> queryWrapper = new EntityWrapper<YuangongEntity>()
            .notIn("id",yuangong.getId())
            .eq("serial", yuangong.getSerial())
            .eq("name", yuangong.getName())
            .eq("age", yuangong.getAge())
            .eq("sex_types", yuangong.getSexTypes())
            .eq("zc_types", yuangong.getZcTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuangongEntity yuangongEntity = yuangongService.selectOne(queryWrapper);
        if(yuangongEntity==null){
            yuangongService.updateById(yuangong);//根据id更新
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
        yuangongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

