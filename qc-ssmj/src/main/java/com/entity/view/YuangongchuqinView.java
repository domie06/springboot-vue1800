package com.entity.view;

import com.entity.YuangongchuqinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 员工出勤表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-24
 */
@TableName("yuangongchuqin")
public class YuangongchuqinView extends YuangongchuqinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public YuangongchuqinView() {

	}

	public YuangongchuqinView(YuangongchuqinEntity yuangongchuqinEntity) {
		try {
			BeanUtils.copyProperties(this, yuangongchuqinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
