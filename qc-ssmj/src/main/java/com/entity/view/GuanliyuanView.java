package com.entity.view;

import com.entity.GuanliyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 管理员表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-24
 */
@TableName("guanliyuan")
public class GuanliyuanView extends GuanliyuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public GuanliyuanView() {

	}

	public GuanliyuanView(GuanliyuanEntity guanliyuanEntity) {
		try {
			BeanUtils.copyProperties(this, guanliyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
