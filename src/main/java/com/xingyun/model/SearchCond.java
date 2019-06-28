package com.xingyun.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 查询条件实体类
 */
public class SearchCond {
    @ApiModelProperty(value = "站点ID",required = true)
    private List<String> siteId;//站点ID
    //@ApiModelProperty(value = "表名",example = "tb_duanmianwq")
    //private String tbName;//表名
    @ApiModelProperty(value = "开始时间",example = "2015-01-01",required = false)
    private String startTime;//开始时间
    @ApiModelProperty(value = "结束时间",example = "2015-01-02",required = false)
    private String endTime;//结束时间
    @ApiModelProperty(value = "查询年均(Year)、月均(Mon)、日均(Day)或降雨和",example = "Day",required = true)
    private String condition;//查询年均、月均、日均等（Year/Mon/Day）

    public List<String> getSiteId() {
        return siteId;
    }

    public void setSiteId(List<String> siteId) {
        this.siteId = siteId;
    }

    /*public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }*/

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "SearchCond{" +
                "siteId='" + siteId + '\'' +
                //", tbName='" + tbName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
