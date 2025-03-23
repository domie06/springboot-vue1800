package com.entity.model;

import com.entity.WeixiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 维修信息表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-24
 */
public class WeixiuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 客户编号  Search
     */
    private Integer serialTypes;


    /**
     * 维修项目Search
     */
    private String maintenance;


    /**
     * 员工工时
     */
    private Integer ygdate;


    /**
     * 维修等级
     */
    private Integer wxTypes;


    /**
     * 配件信息
     */
    private Integer pjTypes;


    /**
     * 维修收费
     */
    private Double money;


    /**
     * 维修日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
