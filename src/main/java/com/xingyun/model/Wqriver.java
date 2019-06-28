package com.xingyun.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Wqriver {
    @Id
    private Integer uniqid;

    /**
     * 编号
     */
    private String staid;

    /**
     * 时间
     */
    private Date dt;

    /**
     * 水温
     */
    private BigDecimal watertemp;

    /**
     * ph酸碱值
     */
    private BigDecimal ph;

    /**
     * 溶解氧
     */
    private BigDecimal dox;

    /**
     * 高锰酸盐指数
     */
    private BigDecimal codmn;

    /**
     * 化学需氧量
     */
    private BigDecimal codcr;

    /**
     * 生物需氧量
     */
    private BigDecimal bod5;

    /**
     * 氨氮
     */
    private BigDecimal nh4;

    /**
     * 总磷
     */
    private BigDecimal tp;

    /**
     * 总氮
     */
    private BigDecimal tn;

    /**
     * 铜
     */
    private BigDecimal cu;

    /**
     * 锌
     */
    private BigDecimal zn;

    /**
     * 氟化物
     */
    private BigDecimal f;

    /**
     * 硒
     */
    private BigDecimal sa;

    /**
     * 砷
     */
    private BigDecimal arsenic;

    /**
     * 汞
     */
    private BigDecimal hg;

    /**
     * 镉
     */
    private BigDecimal cd;

    /**
     * 铬
     */
    private BigDecimal cr;

    /**
     * 铅
     */
    private BigDecimal pb;

    /**
     * 氰化物
     */
    private BigDecimal cyanide;

    /**
     * 挥发酚
     */
    private BigDecimal vp;

    /**
     * 石油类
     */
    private BigDecimal petroleum;

    /**
     * 阴离子表面活性剂
     */
    private BigDecimal asurfactant;

    /**
     * 硫化物
     */
    private BigDecimal sulphide;

    /**
     * 粪大肠菌群
     */
    private BigDecimal dibg;

    /**
     * 叶绿素
     */
    private BigDecimal chla;

    /**
     * 导电率
     */
    private BigDecimal wcond;

    /**
     * 透明度
     */
    private BigDecimal transp;

    /**
     * 硝态氮mg/L
     */
    @Column(name = "no3n")
    private BigDecimal no3N;

    /**
     * 正磷酸盐mg/L
     */
    @Column(name = "po4p")
    private BigDecimal po4P;

    /**
     * 总悬浮物
     */
    private BigDecimal tss;

    /**
     * 硫酸盐
     */
    private BigDecimal so4;

    /**
     * 氯化物
     */
    private BigDecimal chloride;

    /**
     * 硝酸盐
     */
    private BigDecimal hno3;

    /**
     * 铁
     */
    private BigDecimal fe;

    /**
     * 锰
     */
    private BigDecimal mn;

    /**
     * 总有机碳
     */
    private BigDecimal toc;

    /**
     * 浊度
     */
    private BigDecimal ftu;

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
     * 获取水温
     *
     * @return watertemp - 水温
     */
    public BigDecimal getWatertemp() {
        return watertemp;
    }

    /**
     * 设置水温
     *
     * @param watertemp 水温
     */
    public void setWatertemp(BigDecimal watertemp) {
        this.watertemp = watertemp;
    }

    /**
     * 获取ph酸碱值
     *
     * @return ph - ph酸碱值
     */
    public BigDecimal getPh() {
        return ph;
    }

    /**
     * 设置ph酸碱值
     *
     * @param ph ph酸碱值
     */
    public void setPh(BigDecimal ph) {
        this.ph = ph;
    }

    /**
     * 获取溶解氧
     *
     * @return dox - 溶解氧
     */
    public BigDecimal getDox() {
        return dox;
    }

    /**
     * 设置溶解氧
     *
     * @param dox 溶解氧
     */
    public void setDox(BigDecimal dox) {
        this.dox = dox;
    }

    /**
     * 获取高锰酸盐指数
     *
     * @return codmn - 高锰酸盐指数
     */
    public BigDecimal getCodmn() {
        return codmn;
    }

    /**
     * 设置高锰酸盐指数
     *
     * @param codmn 高锰酸盐指数
     */
    public void setCodmn(BigDecimal codmn) {
        this.codmn = codmn;
    }

    /**
     * 获取化学需氧量
     *
     * @return codcr - 化学需氧量
     */
    public BigDecimal getCodcr() {
        return codcr;
    }

    /**
     * 设置化学需氧量
     *
     * @param codcr 化学需氧量
     */
    public void setCodcr(BigDecimal codcr) {
        this.codcr = codcr;
    }

    /**
     * 获取生物需氧量
     *
     * @return bod5 - 生物需氧量
     */
    public BigDecimal getBod5() {
        return bod5;
    }

    /**
     * 设置生物需氧量
     *
     * @param bod5 生物需氧量
     */
    public void setBod5(BigDecimal bod5) {
        this.bod5 = bod5;
    }

    /**
     * 获取氨氮
     *
     * @return nh4 - 氨氮
     */
    public BigDecimal getNh4() {
        return nh4;
    }

    /**
     * 设置氨氮
     *
     * @param nh4 氨氮
     */
    public void setNh4(BigDecimal nh4) {
        this.nh4 = nh4;
    }

    /**
     * 获取总磷
     *
     * @return tp - 总磷
     */
    public BigDecimal getTp() {
        return tp;
    }

    /**
     * 设置总磷
     *
     * @param tp 总磷
     */
    public void setTp(BigDecimal tp) {
        this.tp = tp;
    }

    /**
     * 获取总氮
     *
     * @return tn - 总氮
     */
    public BigDecimal getTn() {
        return tn;
    }

    /**
     * 设置总氮
     *
     * @param tn 总氮
     */
    public void setTn(BigDecimal tn) {
        this.tn = tn;
    }

    /**
     * 获取铜
     *
     * @return cu - 铜
     */
    public BigDecimal getCu() {
        return cu;
    }

    /**
     * 设置铜
     *
     * @param cu 铜
     */
    public void setCu(BigDecimal cu) {
        this.cu = cu;
    }

    /**
     * 获取锌
     *
     * @return zn - 锌
     */
    public BigDecimal getZn() {
        return zn;
    }

    /**
     * 设置锌
     *
     * @param zn 锌
     */
    public void setZn(BigDecimal zn) {
        this.zn = zn;
    }

    /**
     * 获取氟化物
     *
     * @return f - 氟化物
     */
    public BigDecimal getF() {
        return f;
    }

    /**
     * 设置氟化物
     *
     * @param f 氟化物
     */
    public void setF(BigDecimal f) {
        this.f = f;
    }

    /**
     * 获取硒
     *
     * @return sa - 硒
     */
    public BigDecimal getSa() {
        return sa;
    }

    /**
     * 设置硒
     *
     * @param sa 硒
     */
    public void setSa(BigDecimal sa) {
        this.sa = sa;
    }

    /**
     * 获取砷
     *
     * @return arsenic - 砷
     */
    public BigDecimal getArsenic() {
        return arsenic;
    }

    /**
     * 设置砷
     *
     * @param arsenic 砷
     */
    public void setArsenic(BigDecimal arsenic) {
        this.arsenic = arsenic;
    }

    /**
     * 获取汞
     *
     * @return hg - 汞
     */
    public BigDecimal getHg() {
        return hg;
    }

    /**
     * 设置汞
     *
     * @param hg 汞
     */
    public void setHg(BigDecimal hg) {
        this.hg = hg;
    }

    /**
     * 获取镉
     *
     * @return cd - 镉
     */
    public BigDecimal getCd() {
        return cd;
    }

    /**
     * 设置镉
     *
     * @param cd 镉
     */
    public void setCd(BigDecimal cd) {
        this.cd = cd;
    }

    /**
     * 获取铬
     *
     * @return cr - 铬
     */
    public BigDecimal getCr() {
        return cr;
    }

    /**
     * 设置铬
     *
     * @param cr 铬
     */
    public void setCr(BigDecimal cr) {
        this.cr = cr;
    }

    /**
     * 获取铅
     *
     * @return pb - 铅
     */
    public BigDecimal getPb() {
        return pb;
    }

    /**
     * 设置铅
     *
     * @param pb 铅
     */
    public void setPb(BigDecimal pb) {
        this.pb = pb;
    }

    /**
     * 获取氰化物
     *
     * @return cyanide - 氰化物
     */
    public BigDecimal getCyanide() {
        return cyanide;
    }

    /**
     * 设置氰化物
     *
     * @param cyanide 氰化物
     */
    public void setCyanide(BigDecimal cyanide) {
        this.cyanide = cyanide;
    }

    /**
     * 获取挥发酚
     *
     * @return vp - 挥发酚
     */
    public BigDecimal getVp() {
        return vp;
    }

    /**
     * 设置挥发酚
     *
     * @param vp 挥发酚
     */
    public void setVp(BigDecimal vp) {
        this.vp = vp;
    }

    /**
     * 获取石油类
     *
     * @return petroleum - 石油类
     */
    public BigDecimal getPetroleum() {
        return petroleum;
    }

    /**
     * 设置石油类
     *
     * @param petroleum 石油类
     */
    public void setPetroleum(BigDecimal petroleum) {
        this.petroleum = petroleum;
    }

    /**
     * 获取阴离子表面活性剂
     *
     * @return asurfactant - 阴离子表面活性剂
     */
    public BigDecimal getAsurfactant() {
        return asurfactant;
    }

    /**
     * 设置阴离子表面活性剂
     *
     * @param asurfactant 阴离子表面活性剂
     */
    public void setAsurfactant(BigDecimal asurfactant) {
        this.asurfactant = asurfactant;
    }

    /**
     * 获取硫化物
     *
     * @return sulphide - 硫化物
     */
    public BigDecimal getSulphide() {
        return sulphide;
    }

    /**
     * 设置硫化物
     *
     * @param sulphide 硫化物
     */
    public void setSulphide(BigDecimal sulphide) {
        this.sulphide = sulphide;
    }

    /**
     * 获取粪大肠菌群
     *
     * @return dibg - 粪大肠菌群
     */
    public BigDecimal getDibg() {
        return dibg;
    }

    /**
     * 设置粪大肠菌群
     *
     * @param dibg 粪大肠菌群
     */
    public void setDibg(BigDecimal dibg) {
        this.dibg = dibg;
    }

    /**
     * 获取叶绿素
     *
     * @return chla - 叶绿素
     */
    public BigDecimal getChla() {
        return chla;
    }

    /**
     * 设置叶绿素
     *
     * @param chla 叶绿素
     */
    public void setChla(BigDecimal chla) {
        this.chla = chla;
    }

    /**
     * 获取导电率
     *
     * @return wcond - 导电率
     */
    public BigDecimal getWcond() {
        return wcond;
    }

    /**
     * 设置导电率
     *
     * @param wcond 导电率
     */
    public void setWcond(BigDecimal wcond) {
        this.wcond = wcond;
    }

    /**
     * 获取透明度
     *
     * @return transp - 透明度
     */
    public BigDecimal getTransp() {
        return transp;
    }

    /**
     * 设置透明度
     *
     * @param transp 透明度
     */
    public void setTransp(BigDecimal transp) {
        this.transp = transp;
    }

    /**
     * 获取硝态氮mg/L
     *
     * @return no3_n - 硝态氮mg/L
     */
    public BigDecimal getNo3N() {
        return no3N;
    }

    /**
     * 设置硝态氮mg/L
     *
     * @param no3N 硝态氮mg/L
     */
    public void setNo3N(BigDecimal no3N) {
        this.no3N = no3N;
    }

    /**
     * 获取正磷酸盐mg/L
     *
     * @return po4_p - 正磷酸盐mg/L
     */
    public BigDecimal getPo4P() {
        return po4P;
    }

    /**
     * 设置正磷酸盐mg/L
     *
     * @param po4P 正磷酸盐mg/L
     */
    public void setPo4P(BigDecimal po4P) {
        this.po4P = po4P;
    }

    /**
     * 获取总悬浮物
     *
     * @return tss - 总悬浮物
     */
    public BigDecimal getTss() {
        return tss;
    }

    /**
     * 设置总悬浮物
     *
     * @param tss 总悬浮物
     */
    public void setTss(BigDecimal tss) {
        this.tss = tss;
    }

    /**
     * 获取硫酸盐
     *
     * @return so4 - 硫酸盐
     */
    public BigDecimal getSo4() {
        return so4;
    }

    /**
     * 设置硫酸盐
     *
     * @param so4 硫酸盐
     */
    public void setSo4(BigDecimal so4) {
        this.so4 = so4;
    }

    /**
     * 获取氯化物
     *
     * @return chloride - 氯化物
     */
    public BigDecimal getChloride() {
        return chloride;
    }

    /**
     * 设置氯化物
     *
     * @param chloride 氯化物
     */
    public void setChloride(BigDecimal chloride) {
        this.chloride = chloride;
    }

    /**
     * 获取硝酸盐
     *
     * @return hno3 - 硝酸盐
     */
    public BigDecimal getHno3() {
        return hno3;
    }

    /**
     * 设置硝酸盐
     *
     * @param hno3 硝酸盐
     */
    public void setHno3(BigDecimal hno3) {
        this.hno3 = hno3;
    }

    /**
     * 获取铁
     *
     * @return fe - 铁
     */
    public BigDecimal getFe() {
        return fe;
    }

    /**
     * 设置铁
     *
     * @param fe 铁
     */
    public void setFe(BigDecimal fe) {
        this.fe = fe;
    }

    /**
     * 获取锰
     *
     * @return mn - 锰
     */
    public BigDecimal getMn() {
        return mn;
    }

    /**
     * 设置锰
     *
     * @param mn 锰
     */
    public void setMn(BigDecimal mn) {
        this.mn = mn;
    }

    /**
     * 获取总有机碳
     *
     * @return toc - 总有机碳
     */
    public BigDecimal getToc() {
        return toc;
    }

    /**
     * 设置总有机碳
     *
     * @param toc 总有机碳
     */
    public void setToc(BigDecimal toc) {
        this.toc = toc;
    }

    /**
     * 获取浊度
     *
     * @return ftu - 浊度
     */
    public BigDecimal getFtu() {
        return ftu;
    }

    /**
     * 设置浊度
     *
     * @param ftu 浊度
     */
    public void setFtu(BigDecimal ftu) {
        this.ftu = ftu;
    }

    @Override
    public String toString() {
        return "Wqriver{" +
                "uniqid=" + uniqid +
                ", staid='" + staid + '\'' +
                ", dt=" + dt +
                ", watertemp=" + watertemp +
                ", ph=" + ph +
                ", dox=" + dox +
                ", codmn=" + codmn +
                ", codcr=" + codcr +
                ", bod5=" + bod5 +
                ", nh4=" + nh4 +
                ", tp=" + tp +
                ", tn=" + tn +
                ", cu=" + cu +
                ", zn=" + zn +
                ", f=" + f +
                ", sa=" + sa +
                ", arsenic=" + arsenic +
                ", hg=" + hg +
                ", cd=" + cd +
                ", cr=" + cr +
                ", pb=" + pb +
                ", cyanide=" + cyanide +
                ", vp=" + vp +
                ", petroleum=" + petroleum +
                ", asurfactant=" + asurfactant +
                ", sulphide=" + sulphide +
                ", dibg=" + dibg +
                ", chla=" + chla +
                ", wcond=" + wcond +
                ", transp=" + transp +
                ", no3N=" + no3N +
                ", po4P=" + po4P +
                ", tss=" + tss +
                ", so4=" + so4 +
                ", chloride=" + chloride +
                ", hno3=" + hno3 +
                ", fe=" + fe +
                ", mn=" + mn +
                ", toc=" + toc +
                ", ftu=" + ftu +
                '}';
    }
}