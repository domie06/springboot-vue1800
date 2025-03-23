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
 * 维修信息表
 *
 * @author 
 * @email
 * @date 2021-02-24
 */
@TableName("weixiu")
public class WeixiuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WeixiuEntity() {

	}

	public WeixiuEntity(T t) {
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
     * 客户编号  Search
     */
    @TableField(value = "serial_types")
    private Integer serialTypes;


    /**
     * 维修项目Search
     */
    @TableField(value = "maintenance")
    private String maintenance;


    /**
     * 员工工时
     */
    @TableField(value = "ygdate")
    private Integer ygdate;


    /**
     * 维修等级
     */
    @TableField(value = "wx_types")
    private Integer wxTypes;


    /**
     * 配件信息
     */
    @TableField(value = "pj_types")
    private Integer pjTypes;


    /**
     * 维修收费
     */
    @TableField(value = "money")
    private Double money;


    /**
     * 维修日期
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
	 * 设置：客户编号  Search
	 */
    public Integer getSerialTypes() {
        return serialTypes;
    }


    /**
	 * 获取：客户编号  Search
	 */

    public void setSerialTypes(Integer serialTypes) {
        this.serialTypes = serialTypes;
    }
    /**
	 * 设置：维修项目Search
	 */
    public String getMaintenance() {
        return maintenance;
    }


    /**
	 * 获取：维修项目Search
	 */

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }
    /**
	 * 设置：员工工时
	 */
    public Integer getYgdate() {
        return ygdate;
    }


    /**
	 * 获取：员工工时
	 */

    public void setYgdate(Integer ygdate) {
        this.ygdate = ygdate;
    }
    /**
	 * 设置：维修等级
	 */
    public Integer getWxTypes() {
        return wxTypes;
    }


    /**
	 * 获取：维修等级
	 */

    public void setWxTypes(Integer wxTypes) {
        this.wxTypes = wxTypes;
    }
    /**
	 * 设置：配件信息
	 */
    public Integer getPjTypes() {
        return pjTypes;
    }


    /**
	 * 获取：配件信息
	 */

    public void setPjTypes(Integer pjTypes) {
        this.pjTypes = pjTypes;
    }
    /**
	 * 设置：维修收费
	 */
    public Double getMoney() {
        return money;
    }


    /**
	 * 获取：维修收费
	 */

    public void setMoney(Double money) {
        this.money = money;
    }
    /**
	 * 设置：维修日期
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：维修日期
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
