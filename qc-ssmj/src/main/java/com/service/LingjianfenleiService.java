package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LingjianfenleiEntity;
import java.util.Map;

/**
 * 零件分类表 服务类
 * @author 
 * @since 2021-02-24
 */
public interface LingjianfenleiService extends IService<LingjianfenleiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}