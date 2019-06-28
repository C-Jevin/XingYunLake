package com.xingyun.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Stationlist {
    /**
     * 编号
     */
    @Id
    private String staid;

    /**
     * 名称
     */
   // @Id
    private String staname;

    /**
     * 站点所属表
     */
    //@Id
    private String datatable;

    /**
     * 数据类别
     */
    private String cate;

    /**
     * 起始时间
     */
    private Date startdt;

    /**
     * 结束时间
     */
    private Date enddt;

    /**
     * 纬度
     */
    private BigDecimal lat;

    /**
     * 经度
     */
    private BigDecimal lon;

    /**
     * 数据来源
     */
    private String dataresource;

    /**
     * 数据精度
     */
    private String dataaccur;

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
     * 获取名称
     *
     * @return staname - 名称
     */
    public String getStaname() {
        return staname;
    }

    /**
     * 设置名称
     *
     * @param staname 名称
     */
    public void setStaname(String staname) {
        this.staname = staname;
    }

    /**
     * 获取站点所属表
     *
     * @return datatable - 站点所属表
     */
    public String getDatatable() {
        return datatable;
    }

    /**
     * 设置站点所属表
     *
     * @param datatable 站点所属表
     */
    public void setDatatable(String datatable) {
        this.datatable = datatable;
    }

    /**
     * 获取数据类别
     *
     * @return cate - 数据类别
     */
    public String getCate() {
        return cate;
    }

    /**
     * 设置数据类别
     *
     * @param cate 数据类别
     */
    public void setCate(String cate) {
        this.cate = cate;
    }

    /**
     * 获取起始时间
     *
     * @return startdt - 起始时间
     */
    public Date getStartdt() {
        return startdt;
    }

    /**
     * 设置起始时间
     *
     * @param startdt 起始时间
     */
    public void setStartdt(Date startdt) {
        this.startdt = startdt;
    }

    /**
     * 获取结束时间
     *
     * @return enddt - 结束时间
     */
    public Date getEnddt() {
        return enddt;
    }

    /**
     * 设置结束时间
     *
     * @param enddt 结束时间
     */
    public void setEnddt(Date enddt) {
        this.enddt = enddt;
    }

    /**
     * 获取纬度
     *
     * @return lat - 纬度
     */
    public BigDecimal getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat 纬度
     */
    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    /**
     * 获取经度
     *
     * @return lon - 经度
     */
    public BigDecimal getLon() {
        return lon;
    }

    /**
     * 设置经度
     *
     * @param lon 经度
     */
    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    /**
     * 获取数据来源
     *
     * @return dataresource - 数据来源
     */
    public String getDataresource() {
        return dataresource;
    }

    /**
     * 设置数据来源
     *
     * @param dataresource 数据来源
     */
    public void setDataresource(String dataresource) {
        this.dataresource = dataresource;
    }

    /**
     * 获取数据精度
     *
     * @return dataaccur - 数据精度
     */
    public String getDataaccur() {
        return dataaccur;
    }

    /**
     * 设置数据精度
     *
     * @param dataaccur 数据精度
     */
    public void setDataaccur(String dataaccur) {
        this.dataaccur = dataaccur;
    }

    @Override
    public String toString() {
        return "Stationlist{" +
                "staid='" + staid + '\'' +
                ", staname='" + staname + '\'' +
                ", datatable='" + datatable + '\'' +
                ", cate='" + cate + '\'' +
                ", startdt=" + startdt +
                ", enddt=" + enddt +
                ", lat=" + lat +
                ", lon=" + lon +
                ", dataresource='" + dataresource + '\'' +
                ", dataaccur='" + dataaccur + '\'' +
                '}';
    }
}