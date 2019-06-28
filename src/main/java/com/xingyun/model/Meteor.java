package com.xingyun.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Meteor {
    @Id
    private Integer uniqid;

   // @Id
    private String staid;

   // @Id
    private Date dt;

    /**
     * 大气压
     */
    private BigDecimal pressure;

    /**
     * 气温
     */
    private BigDecimal temperature;

    /**
     * 相对湿度
     */
    private BigDecimal humidity;

    /**
     * 降雨
     */
    private BigDecimal prep;

    /**
     * 风速
     */
    private BigDecimal windspeed;

    /**
     * 风向
     */
    private BigDecimal winddirect;

    /**
     * 太阳总辐射曝辐量(MJ/m2)
     */
    private BigDecimal solrad;

    /**
     * 大型蒸发量(mm)
     */
    private BigDecimal eva;

    /**
     * 总云量(成)  0--10
     */
    private BigDecimal cloud;

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
     * @return staid
     */
    public String getStaid() {
        return staid;
    }

    /**
     * @param staid
     */
    public void setStaid(String staid) {
        this.staid = staid;
    }

    /**
     * @return dt
     */
    public Date getDt() {
        return dt;
    }

    /**
     * @param dt
     */
    public void setDt(Date dt) {
        this.dt = dt;
    }

    /**
     * 获取大气压
     *
     * @return pressure - 大气压
     */
    public BigDecimal getPressure() {
        return pressure;
    }

    /**
     * 设置大气压
     *
     * @param pressure 大气压
     */
    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    /**
     * 获取气温
     *
     * @return temperature - 气温
     */
    public BigDecimal getTemperature() {
        return temperature;
    }

    /**
     * 设置气温
     *
     * @param temperature 气温
     */
    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    /**
     * 获取相对湿度
     *
     * @return humidity - 相对湿度
     */
    public BigDecimal getHumidity() {
        return humidity;
    }

    /**
     * 设置相对湿度
     *
     * @param humidity 相对湿度
     */
    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    /**
     * 获取降雨
     *
     * @return prep - 降雨
     */
    public BigDecimal getPrep() {
        return prep;
    }

    /**
     * 设置降雨
     *
     * @param prep 降雨
     */
    public void setPrep(BigDecimal prep) {
        this.prep = prep;
    }

    /**
     * 获取风速
     *
     * @return windspeed - 风速
     */
    public BigDecimal getWindspeed() {
        return windspeed;
    }

    /**
     * 设置风速
     *
     * @param windspeed 风速
     */
    public void setWindspeed(BigDecimal windspeed) {
        this.windspeed = windspeed;
    }

    /**
     * 获取风向
     *
     * @return winddirect - 风向
     */
    public BigDecimal getWinddirect() {
        return winddirect;
    }

    /**
     * 设置风向
     *
     * @param winddirect 风向
     */
    public void setWinddirect(BigDecimal winddirect) {
        this.winddirect = winddirect;
    }

    /**
     * 获取太阳总辐射曝辐量(MJ/m2)
     *
     * @return solrad - 太阳总辐射曝辐量(MJ/m2)
     */
    public BigDecimal getSolrad() {
        return solrad;
    }

    /**
     * 设置太阳总辐射曝辐量(MJ/m2)
     *
     * @param solrad 太阳总辐射曝辐量(MJ/m2)
     */
    public void setSolrad(BigDecimal solrad) {
        this.solrad = solrad;
    }

    /**
     * 获取大型蒸发量(mm)
     *
     * @return eva - 大型蒸发量(mm)
     */
    public BigDecimal getEva() {
        return eva;
    }

    /**
     * 设置大型蒸发量(mm)
     *
     * @param eva 大型蒸发量(mm)
     */
    public void setEva(BigDecimal eva) {
        this.eva = eva;
    }

    /**
     * 获取总云量(成)  0--10
     *
     * @return cloud - 总云量(成)  0--10
     */
    public BigDecimal getCloud() {
        return cloud;
    }

    /**
     * 设置总云量(成)  0--10
     *
     * @param cloud 总云量(成)  0--10
     */
    public void setCloud(BigDecimal cloud) {
        this.cloud = cloud;
    }

    @Override
    public String toString() {
        return "Meteor{" +
                "uniqid=" + uniqid +
                ", staid='" + staid + '\'' +
                ", dt=" + dt +
                ", pressure=" + pressure +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", prep=" + prep +
                ", windspeed=" + windspeed +
                ", winddirect=" + winddirect +
                ", solrad=" + solrad +
                ", eva=" + eva +
                ", cloud=" + cloud +
                '}';
    }
}