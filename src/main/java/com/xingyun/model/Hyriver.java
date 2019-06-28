package com.xingyun.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Hyriver {
    @Id
    private Integer uniqid;

    //@Id
    private String staid;

   // @Id
    private Date dt;

    private BigDecimal waterlevel;

    private BigDecimal discharge;

    private BigDecimal velocity;

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
     * @return waterlevel
     */
    public BigDecimal getWaterlevel() {
        return waterlevel;
    }

    /**
     * @param waterlevel
     */
    public void setWaterlevel(BigDecimal waterlevel) {
        this.waterlevel = waterlevel;
    }

    /**
     * @return discharge
     */
    public BigDecimal getDischarge() {
        return discharge;
    }

    /**
     * @param discharge
     */
    public void setDischarge(BigDecimal discharge) {
        this.discharge = discharge;
    }

    /**
     * @return velocity
     */
    public BigDecimal getVelocity() {
        return velocity;
    }

    /**
     * @param velocity
     */
    public void setVelocity(BigDecimal velocity) {
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return "Hyriver{" +
                "uniqid=" + uniqid +
                ", staid='" + staid + '\'' +
                ", dt=" + dt +
                ", waterlevel=" + waterlevel +
                ", discharge=" + discharge +
                ", velocity=" + velocity +
                '}';
    }
}