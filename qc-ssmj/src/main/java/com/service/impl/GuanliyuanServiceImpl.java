package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.GuanliyuanDao;
import com.entity.GuanliyuanEntity;
import com.service.GuanliyuanService;
import com.entity.view.GuanliyuanView;

/**
 * 管理员表 服务实现类
 * @author 
 * @since 2021-02-24
 */
@Service("guanliyuanService")
@Transactional
public class GuanliyuanServiceImpl extends ServiceImpl<GuanliyuanDao, GuanliyuanEntity> implements GuanliyuanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<GuanliyuanView> page =new Query<GuanliyuanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
