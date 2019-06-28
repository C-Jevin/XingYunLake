package com.xingyun.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Rain {
    @Id
    private Integer uniqid;

    /**
     * 编号
     */
   // @Id
    private String staid;

    /**
     * 时间
     */
   // @Id
    private Date dt;

    /**
     * 水位
     */
    private BigDecimal prep;

    /**
     * @return uniqid
     */
    public Integer getUniqid() {
        return uniqid;
    }

    /**
     * @param uniqid
     */
    public void setUniqid(Integer uniqid) {
        this.uniqid = uniqid;
    }

    /**
     * 获取编号
     *
     * @return staid - 编号
     */
    public String getStaid() {
        return staid;
    }

    /**
     * 设置编号
     *
     * @param staid 编号
     */
    public void setStaid(String staid) {
        this.staid = staid;
    }

    /**
     * 获取时间
     *
     * @return dt - 时间
     */
    public Date getDt() {
        return dt;
    }

    /**
     * 设置时间
     *
     * @param dt 时间
     */
    public void setDt(Date dt) {
        this.dt = dt;
    }

    /**
     * 获取水位
     *
     * @return prep - 水位
     */
    public BigDecimal getPrep() {
        return prep;
    }

    /**
     * 设置水位
     *
     * @param prep 水位
     */
    public void setPrep(BigDecimal prep) {
        this.prep = prep;
    }

    @Override
    public String toString() {
        return "Rain{" +
                "uniqid=" + uniqid +
                ", staid='" + staid + '\'' +
                ", dt=" + dt +
                ", prep=" + prep +
                '}';
    }
}