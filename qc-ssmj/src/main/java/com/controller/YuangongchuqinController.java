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

import com.entity.YuangongchuqinEntity;

import com.service.YuangongchuqinService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 员工出勤表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-24
*/
@RestController
@Controller
@RequestMapping("/yuangongchuqin")
public class YuangongchuqinController {
    private static final Logger logger = LoggerFactory.getLogger(YuangongchuqinController.class);

    @Autowired
    private YuangongchuqinService yuangongchuqinService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = yuangongchuqinService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        YuangongchuqinEntity yuangongchuqin = yuangongchuqinService.selectById(id);
        if(yuangongchuqin!=null){
            return R.ok().put("data", yuangongchuqin);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongchuqinEntity yuangongchuqin, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<YuangongchuqinEntity> queryWrapper = new EntityWrapper<YuangongchuqinEntity>()
            .eq("serial_types", yuangongchuqin.getSerialTypes())
            .eq("cq_types", yuangongchuqin.getCqTypes())
            .eq("notice_content", yuangongchuqin.getNoticeContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuangongchuqinEntity yuangongchuqinEntity = yuangongchuqinService.selectOne(queryWrapper);
        if(yuangongchuqinEntity==null){
            yuangongchuqinService.insert(yuangongchuqin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuangongchuqinEntity yuangongchuqin, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<YuangongchuqinEntity> queryWrapper = new EntityWrapper<YuangongchuqinEntity>()
            .notIn("id",yuangongchuqin.getId())
            .eq("serial_types", yuangongchuqin.getSerialTypes())
            .eq("cq_types", yuangongchuqin.getCqTypes())
            .eq("notice_content", yuangongchuqin.getNoticeContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuangongchuqinEntity yuangongchuqinEntity = yuangongchuqinService.selectOne(queryWrapper);
        if(yuangongchuqinEntity==null){
            yuangongchuqinService.updateById(yuangongchuqin);//根据id更新
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
        yuangongchuqinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

