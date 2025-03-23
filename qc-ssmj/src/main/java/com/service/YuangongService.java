package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuangongEntity;
import java.util.Map;

/**
 * 员工表 服务类
 * @author 
 * @since 2021-02-24
 */
public interface YuangongService extends IService<YuangongEntity> {

     PageUtils queryPage(Map<String, Object> params);

}