package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.LingjianfenleiDao;
import com.entity.LingjianfenleiEntity;
import com.service.LingjianfenleiService;
import com.entity.view.LingjianfenleiView;

/**
 * 零件分类表 服务实现类
 * @author 
 * @since 2021-02-24
 */
@Service("lingjianfenleiService")
@Transactional
public class LingjianfenleiServiceImpl extends ServiceImpl<LingjianfenleiDao, LingjianfenleiEntity> implements LingjianfenleiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<LingjianfenleiView> page =new Query<LingjianfenleiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
