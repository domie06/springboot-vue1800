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
 * 员工出勤表
 *
 * @author 
 * @email
 * @date 2021-02-24
 */
@TableName("yuangongchuqin")
public class YuangongchuqinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YuangongchuqinEntity() {

	}

	public YuangongchuqinEntity(T t) {
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
     * 员工编号  Search
     */
    @TableField(value = "serial_types")
    private Integer serialTypes;


    /**
     * 出勤状况
     */
    @TableField(value = "cq_types")
    private Integer cqTypes;


    /**
     * 考勤日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time")
    private Date createTime;


    /**
     * 备注
     */
    @TableField(value = "notice_content")
    private String noticeContent;


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
	 * 设置：员工编号  Search
	 */
    public Integer getSerialTypes() {
        return serialTypes;
    }


    /**
	 * 获取：员工编号  Search
	 */

    public void setSerialTypes(Integer serialTypes) {
        this.serialTypes = serialTypes;
    }
    /**
	 * 设置：出勤状况
	 */
    public Integer getCqTypes() {
        return cqTypes;
    }


    /**
	 * 获取：出勤状况
	 */

    public void setCqTypes(Integer cqTypes) {
        this.cqTypes = cqTypes;
    }
    /**
	 * 设置：考勤日期
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：考勤日期
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
	 * 设置：备注
	 */
    public String getNoticeContent() {
        return noticeContent;
    }


    /**
	 * 获取：备注
	 */

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

}
