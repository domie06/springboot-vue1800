package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 零件设备表
 *
 * @author 
 * @email
 * @date 2021-02-24
 */
@TableName("lingjainshebei")
public class LingjainshebeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LingjainshebeiEntity() {

	}

	public LingjainshebeiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Integer id;


    /**
     * 零件编号  Search
     */
    @TableField(value = "serial")
    private String serial;


    /**
     * 零件名称  Search
     */
    @TableField(value = "name")
    private String name;


    /**
     * 零件分类
     */
    @TableField(value = "lj_types")
    private Integer ljTypes;


    /**
     * 零件数量
     */
    @TableField(value = "amount")
    private Integer amount;


    /**
     * 生产单位
     */
    @TableField(value = "production")
    private Integer production;


    /**
     * 采购日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：零件编号  Search
	 */
    public String getSerial() {
        return serial;
    }


    /**
	 * 获取：零件编号  Search
	 */

    public void setSerial(String serial) {
        this.serial = serial;
    }
    /**
	 * 设置：零件名称  Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：零件名称  Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：零件分类
	 */
    public Integer getLjTypes() {
        return ljTypes;
    }


    /**
	 * 获取：零件分类
	 */

    public void setLjTypes(Integer ljTypes) {
        this.ljTypes = ljTypes;
    }
    /**
	 * 设置：零件数量
	 */
    public Integer getAmount() {
        return amount;
    }


    /**
	 * 获取：零件数量
	 */

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    /**
	 * 设置：生产单位
	 */
    public Integer getProduction() {
        return production;
    }


    /**
	 * 获取：生产单位
	 */

    public void setProduction(Integer production) {
        this.production = production;
    }
    /**
	 * 设置：采购日期
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：采购日期
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
