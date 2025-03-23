package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.LingjainshebeiDao;
import com.entity.LingjainshebeiEntity;
import com.service.LingjainshebeiService;
import com.entity.view.LingjainshebeiView;

/**
 * 零件设备表 服务实现类
 * @author 
 * @since 2021-02-24
 */
@Service("lingjainshebeiService")
@Transactional
public class LingjainshebeiServiceImpl extends ServiceImpl<LingjainshebeiDao, LingjainshebeiEntity> implements LingjainshebeiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<LingjainshebeiView> page =new Query<LingjainshebeiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
