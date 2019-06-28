package com.xingyun.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Hylake {
    @Id
    private Integer uniqid;

    /**
     * 编号
     */
    //@Id
    private String staid;

    /**
     * 时间
     */
    //@Id
    private Date dt;

    /**
     * 水位
     */
    private BigDecimal waterlevel;

    /**
     * 水量 万方
     */
    private BigDecimal volume;

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
     * @return waterlevel - 水位
     */
    public BigDecimal getWaterlevel() {
        return waterlevel;
    }

    /**
     * 设置水位
     *
     * @param waterlevel 水位
     */
    public void setWaterlevel(BigDecimal waterlevel) {
        this.waterlevel = waterlevel;
    }

    /**
     * 获取水量 万方
     *
     * @return volume - 水量 万方
     */
    public BigDecimal getVolume() {
        return volume;
    }

    /**
     * 设置水量 万方
     *
     * @param volume 水量 万方
     */
    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Hylake{" +
                "uniqid=" + uniqid +
                ", staid='" + staid + '\'' +
                ", dt=" + dt +
                ", waterlevel=" + waterlevel +
                ", volume=" + volume +
                '}';
    }
}