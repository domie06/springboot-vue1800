package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KehuEntity;
import java.util.Map;

/**
 * 客户信息表 服务类
 * @author 
 * @since 2021-02-24
 */
public interface KehuService extends IService<KehuEntity> {

     PageUtils queryPage(Map<String, Object> params);

}