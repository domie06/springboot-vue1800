package com.dao;

import com.entity.YuangongchuqinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuangongchuqinView;

/**
 * 员工出勤表 Dao 接口
 *
 * @author 
 * @since 2021-02-24
 */
public interface YuangongchuqinDao extends BaseMapper<YuangongchuqinEntity> {

   List<YuangongchuqinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
