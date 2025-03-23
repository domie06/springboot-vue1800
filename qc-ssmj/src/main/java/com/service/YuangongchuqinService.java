package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuangongchuqinEntity;
import java.util.Map;

/**
 * 员工出勤表 服务类
 * @author 
 * @since 2021-02-24
 */
public interface YuangongchuqinService extends IService<YuangongchuqinEntity> {

     PageUtils queryPage(Map<String, Object> params);

}