package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeixiuEntity;
import java.util.Map;

/**
 * 维修信息表 服务类
 * @author 
 * @since 2021-02-24
 */
public interface WeixiuService extends IService<WeixiuEntity> {

     PageUtils queryPage(Map<String, Object> params);

}