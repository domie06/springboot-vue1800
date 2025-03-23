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
 * 管理员表
 *
 * @author 
 * @email
 * @date 2021-02-24
 */
@TableName("guanliyuan")
public class GuanliyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GuanliyuanEntity() {

	}

	public GuanliyuanEntity(T t) {
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
     * 编号  Search
     */
    @TableField(value = "serial")
    private String serial;


    /**
     * 姓名  Search
     */
    @TableField(value = "name")
    private String name;


    /**
     * 账号  Search
     */
    @TableField(value = "account")
    private String account;


    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;


    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;


    /**
     * 性别
     */
    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电话
     */
    @TableField(value = "mobile")
    private String mobile;


    /**
     * 住址
     */
    @TableField(value = "address")
    private String address;


    /**
     * 身份
     */
    @TableField(value = "role")
    private String role;


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
	 * 设置：编号  Search
	 */
    public String getSerial() {
        return serial;
    }


    /**
	 * 获取：编号  Search
	 */

    public void setSerial(String serial) {
        this.serial = serial;
    }
    /**
	 * 设置：姓名  Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：姓名  Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：账号  Search
	 */
    public String getAccount() {
        return account;
    }


    /**
	 * 获取：账号  Search
	 */

    public void setAccount(String account) {
        this.account = account;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 获取：年龄
	 */

    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电话
	 */
    public String getMobile() {
        return mobile;
    }


    /**
	 * 获取：电话
	 */

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**
	 * 设置：住址
	 */
    public String getAddress() {
        return address;
    }


    /**
	 * 获取：住址
	 */

    public void setAddress(String address) {
        this.address = address;
    }
    /**
	 * 设置：身份
	 */
    public String getRole() {
        return role;
    }


    /**
	 * 获取：身份
	 */

    public void setRole(String role) {
        this.role = role;
    }

}
