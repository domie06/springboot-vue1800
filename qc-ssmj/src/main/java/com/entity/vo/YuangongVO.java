package com.entity.vo;

import com.entity.YuangongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 员工表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-24
 */
@TableName("yuangong")
public class YuangongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 员工编号  Search
     */

    @TableField(value = "serial")
    private String serial;


    /**
     * 员工姓名  Search
     */

    @TableField(value = "name")
    private String name;


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
     * 技术职称  Search
     */

    @TableField(value = "zc_types")
    private Integer zcTypes;


    /**
     * 入职日期
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
	 * 设置：员工编号  Search
	 */
    public String getSerial() {
        return serial;
    }


    /**
	 * 获取：员工编号  Search
	 */

    public void setSerial(String serial) {
        this.serial = serial;
    }
    /**
	 * 设置：员工姓名  Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：员工姓名  Search
	 */

    public void setName(String name) {
        this.name = name;
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
	 * 设置：技术职称  Search
	 */
    public Integer getZcTypes() {
        return zcTypes;
    }


    /**
	 * 获取：技术职称  Search
	 */

    public void setZcTypes(Integer zcTypes) {
        this.zcTypes = zcTypes;
    }
    /**
	 * 设置：入职日期
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：入职日期
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
