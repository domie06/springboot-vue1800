package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LingjainshebeiEntity;
import java.util.Map;

/**
 * 零件设备表 服务类
 * @author 
 * @since 2021-02-24
 */
public interface LingjainshebeiService extends IService<LingjainshebeiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}