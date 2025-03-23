package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuanliyuanEntity;
import java.util.Map;

/**
 * 管理员表 服务类
 * @author 
 * @since 2021-02-24
 */
public interface GuanliyuanService extends IService<GuanliyuanEntity> {

     PageUtils queryPage(Map<String, Object> params);

}