package com.dao;

import com.entity.LingjianfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LingjianfenleiView;

/**
 * 零件分类表 Dao 接口
 *
 * @author 
 * @since 2021-02-24
 */
public interface LingjianfenleiDao extends BaseMapper<LingjianfenleiEntity> {

   List<LingjianfenleiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
