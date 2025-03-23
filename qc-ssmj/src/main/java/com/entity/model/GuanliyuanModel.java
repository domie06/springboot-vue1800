package com.entity.model;

import com.entity.GuanliyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 管理员表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-24
 */
public class GuanliyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 编号  Search
     */
    private String serial;


    /**
     * 姓名  Search
     */
    private String name;


    /**
     * 账号  Search
     */
    private String account;


    /**
     * 密码
     */
    private String password;


    /**
     * 年龄
     */
    private Integer age;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电话
     */
    private String mobile;


    /**
     * 住址
     */
    private String address;


    /**
     * 身份
     */
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
