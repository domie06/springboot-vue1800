package com.entity.vo;

import com.entity.KehuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 客户信息表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-24
 */
@TableName("kehu")
public class KehuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 客户编号  Search
     */

    @TableField(value = "serial")
    private String serial;


    /**
     * 客户姓名  Search
     */

    @TableField(value = "name")
    private String name;


    /**
     * 账号
     */

    @TableField(value = "account")
    private String account;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 客户年龄
     */

    @TableField(value = "age")
    private Integer age;


    /**
     * 客户性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 联系方式
     */

    @TableField(value = "mobile")
    private String mobile;


    /**
     * 身份
     */

    @TableField(value = "role")
    private String role;


    /**
     * 车辆信息
     */

    @TableField(value = "information")
    private String information;


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
    public String getSerial() {
        return serial;
    }


    /**
	 * 获取：客户编号  Search
	 */

    public void setSerial(String serial) {
        this.serial = serial;
    }
    /**
	 * 设置：客户姓名  Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：客户姓名  Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：账号
	 */
    public String getAccount() {
        return account;
    }


    /**
	 * 获取：账号
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
	 * 设置：客户年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 获取：客户年龄
	 */

    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 设置：客户性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：客户性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：联系方式
	 */
    public String getMobile() {
        return mobile;
    }


    /**
	 * 获取：联系方式
	 */

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
    /**
	 * 设置：车辆信息
	 */
    public String getInformation() {
        return information;
    }


    /**
	 * 获取：车辆信息
	 */

    public void setInformation(String information) {
        this.information = information;
    }

}
