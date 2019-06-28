package com.xingyun.service.impl;

import com.xingyun.core.CondOfHyWq;
import com.xingyun.core.UseCondOfHyWq;
import com.xingyun.dao.WqriverMapper;
import com.xingyun.model.Stationlist;
import com.xingyun.model.Wqriver;
import com.xingyun.model.Wqriver;
import com.xingyun.service.WqriverService;
import com.xingyun.core.AbstractService;
import com.xingyun.util.AverageDateUtil;
import com.xingyun.util.DateUtil;
import com.xingyun.util.EmptySentence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/06/17.
 */
@Service
@Transactional
public class WqriverServiceImpl extends AbstractService<Wqriver> implements WqriverService {
    @Resource
    private WqriverMapper wqriverMapper;

    /**
     * 获取平均值
     * @param models
     * @param dateList
     * @param cond
     * @return
     */
    @Override
    public List<Wqriver> averDate(List<Wqriver> models,List<String> dateList,String cond) {

        List<Wqriver> sameResult = new ArrayList<>();
        for (int i = 0; i < dateList.size(); i++) {
            String date = dateList.get(i);
            List<Wqriver> sameDateRes = new ArrayList<>();
            for(Wqriver wqriver : models){
                Date strDate = wqriver.getDt();
                boolean fsame = AverageDateUtil.findSame(cond,strDate,date);
                if(fsame){
                    sameDateRes.add(wqriver);
                }
            }
            //System.err.println("sameDateRes.size="+sameDateRes.size());
            /*if(sameDateRes.size()>0) {
                Double totalwatertemp = 0d;
                Double totalph = 0d;
                Double totaldox = 0d;
                Double totalcodmn = 0d;
                Double totalcodcr = 0d;
                Double totalbod5 = 0d;
                Double totalnh4 = 0d;
                Double totaltp = 0d;
                Double totaltn = 0d;
                Double totalcu = 0d;
                Double totalzn = 0d;
                Double totalf = 0d;
                Double totalsa = 0d;
                Double totalarsenic = 0d;
                Double totalhg = 0d;
                Double totalcd = 0d;
                Double totalcr = 0d;
                Double totalpb = 0d;
                Double totalcyanide = 0d;
                Double totalvp = 0d;
                Double totalpetroleum = 0d;
                Double totalasurfactant = 0d;
                Double totalsulphide = 0d;
                Double totaldibg = 0d;
                Double totalchla = 0d;
                Double totalwcond = 0d;
                Double totaltransp = 0d;
                Double totalno3N = 0d;
                Double totalpo4P = 0d;
                Double totaltss = 0d;
                Double totalso4 = 0d;
                Double totalchloride = 0d;
                Double totalhno3 = 0d;
                Double totalfe = 0d;
                Double totalmn = 0d;
                Double totaltoc = 0d;
                Double totalftu = 0d;
                for (Wqriver wqriver : sameDateRes) {
                   // System.err.println("Ex---"+wqriver.getWatertemp());
                    totalwatertemp +=EmptySentence.judeEmpty(wqriver.getWatertemp());
                    totalph += EmptySentence.judeEmpty(wqriver.getPh());
                    totaldox +=EmptySentence.judeEmpty(wqriver.getDox());
                    totalcodmn += EmptySentence.judeEmpty(wqriver.getCodmn());
                    totalcodcr +=EmptySentence.judeEmpty(wqriver.getCodcr());
                    totalbod5 += EmptySentence.judeEmpty(wqriver.getBod5());
                    totalnh4 +=EmptySentence.judeEmpty(wqriver.getNh4());
                    totaltp += EmptySentence.judeEmpty(wqriver.getTp());
                    totaltn +=EmptySentence.judeEmpty(wqriver.getTn());
                    totalcu += EmptySentence.judeEmpty(wqriver.getCu());
                    totalzn +=EmptySentence.judeEmpty(wqriver.getZn());
                    totalf += EmptySentence.judeEmpty(wqriver.getF());
                    totalsa +=EmptySentence.judeEmpty(wqriver.getSa());
                    totalarsenic +=EmptySentence.judeEmpty(wqriver.getArsenic());
                    totalhg += EmptySentence.judeEmpty(wqriver.getHg());
                    totalcd +=EmptySentence.judeEmpty(wqriver.getCd());
                    totalcr += EmptySentence.judeEmpty(wqriver.getCr());
                    totalpb +=EmptySentence.judeEmpty(wqriver.getPb());
                    totalcyanide += EmptySentence.judeEmpty(wqriver.getCyanide());
                    totalvp +=EmptySentence.judeEmpty(wqriver.getVp());
                    totalpetroleum += EmptySentence.judeEmpty(wqriver.getPetroleum());
                    totalasurfactant +=EmptySentence.judeEmpty(wqriver.getAsurfactant());
                    totalsulphide += EmptySentence.judeEmpty(wqriver.getSulphide());
                    totaldibg +=EmptySentence.judeEmpty(wqriver.getDibg());
                    totalchla += EmptySentence.judeEmpty(wqriver.getChla());
                    totalwcond +=EmptySentence.judeEmpty(wqriver.getWcond());
                    totaltransp += EmptySentence.judeEmpty(wqriver.getTransp());
                    totalno3N +=EmptySentence.judeEmpty(wqriver.getNo3N());
                    totalpo4P += EmptySentence.judeEmpty(wqriver.getPo4P());
                    totaltss +=EmptySentence.judeEmpty(wqriver.getTss());
                    totalso4 += EmptySentence.judeEmpty(wqriver.getSo4());
                    totalchloride +=EmptySentence.judeEmpty(wqriver.getChloride());
                    totalhno3 += EmptySentence.judeEmpty(wqriver.getHno3());
                    totalfe +=EmptySentence.judeEmpty(wqriver.getFe());
                    totalmn += EmptySentence.judeEmpty(wqriver.getMn());
                    totaltoc +=EmptySentence.judeEmpty(wqriver.getToc());
                    totalftu += EmptySentence.judeEmpty(wqriver.getFtu());
                    System.out.println();
                }
                Double averwatertemp = totalwatertemp/sameDateRes.size();
                Double averph = totalph/sameDateRes.size();
                Double averdox = totaldox/sameDateRes.size();
                Double avercodmn = totalcodmn/sameDateRes.size();
                Double avercodcr = totalcodcr/sameDateRes.size();
                Double averbod5 = totalbod5/sameDateRes.size();
                Double avernh4 = totalnh4/sameDateRes.size();
                Double avertp = totaltp/sameDateRes.size();
                Double avertn = totaltn/sameDateRes.size();
                Double avercu = totalcu/sameDateRes.size();
                Double averzn = totalzn/sameDateRes.size();
                Double averf = totalf/sameDateRes.size();
                Double aversa = totalsa/sameDateRes.size();
                Double averarsenic = totalarsenic/sameDateRes.size();
                Double averhg = totalhg/sameDateRes.size();
                Double avercd = totalcd/sameDateRes.size();
                Double avercr = totalcr/sameDateRes.size();
                Double averpb = totalpb/sameDateRes.size();
                Double avercyanide = totalcyanide/sameDateRes.size();
                Double avervp = totalvp/sameDateRes.size();
                Double averpetroleum = totalpetroleum/sameDateRes.size();
                Double averasurfactant = totalasurfactant/sameDateRes.size();
                Double aversulphide = totalsulphide/sameDateRes.size();
                Double averdibg = totaldibg/sameDateRes.size();
                Double averchla = totalchla/sameDateRes.size();
                Double averwcond = totalwcond/sameDateRes.size();
                Double avertransp = totaltransp/sameDateRes.size();
                Double averno3N = totalno3N/sameDateRes.size();
                Double averpo4P = totalpo4P/sameDateRes.size();
                Double avertss = totaltss/sameDateRes.size();
                Double averso4 = totalso4/sameDateRes.size();
                Double averchloride = totalchloride/sameDateRes.size();
                Double averhno3 = totalhno3/sameDateRes.size();
                Double averfe = totalfe/sameDateRes.size();
                Double avermn = totalmn/sameDateRes.size();
                Double avertoc = totaltoc/sameDateRes.size();
                Double averftu = totalftu/sameDateRes.size();
                Wqriver wqriver = new Wqriver();
                wqriver.setWatertemp(new BigDecimal(averwatertemp));
                wqriver.setPh(new BigDecimal(averph));
                wqriver.setDox(new BigDecimal(averdox));
                wqriver.setCodmn(new BigDecimal(avercodmn));
                wqriver.setCodcr(new BigDecimal(avercodcr));
                wqriver.setBod5(new BigDecimal(averbod5));
                wqriver.setNh4(new BigDecimal(avernh4));
                wqriver.setTp(new BigDecimal(avertp));
                wqriver.setTn(new BigDecimal(avertn));
                wqriver.setCu(new BigDecimal(avercu));
                wqriver.setZn(new BigDecimal(averzn));
                wqriver.setF(new BigDecimal(averf));
                wqriver.setSa(new BigDecimal(aversa));
                wqriver.setArsenic(new BigDecimal(averarsenic));
                wqriver.setHg(new BigDecimal(averhg));
                wqriver.setCd(new BigDecimal(avercd));
                wqriver.setCr(new BigDecimal(avercr));
                wqriver.setPb(new BigDecimal(averpb));
                wqriver.setCyanide(new BigDecimal(avercyanide));
                wqriver.setVp(new BigDecimal(avervp));
                wqriver.setPetroleum(new BigDecimal(averpetroleum));
                wqriver.setAsurfactant(new BigDecimal(averasurfactant));
                wqriver.setSulphide(new BigDecimal(aversulphide));
                wqriver.setDibg(new BigDecimal(averdibg));
                wqriver.setChla(new BigDecimal(averchla));
                wqriver.setWcond(new BigDecimal(averwcond));
                wqriver.setTransp(new BigDecimal(avertransp));
                wqriver.setNo3N(new BigDecimal(averno3N));
                wqriver.setPo4P(new BigDecimal(averpo4P));
                wqriver.setTss(new BigDecimal(avertss));
                wqriver.setSo4(new BigDecimal(averso4));
                wqriver.setChloride(new BigDecimal(averchloride));
                wqriver.setHno3(new BigDecimal(averhno3));
                wqriver.setFe(new BigDecimal(averfe));
                wqriver.setMn(new BigDecimal(avermn));
                wqriver.setToc(new BigDecimal(avertoc));
                wqriver.setFtu(new BigDecimal(averftu));
                wqriver.setDt(DateUtil.getDateFromStr(date,AverageDateUtil.findFormat(cond)));
                wqriver.setStaid(sameDateRes.get(0).getStaid());
                sameResult.add(wqriver);
            }*/
            Wqriver wqriver = calculate(sameDateRes);
            if (wqriver!=null){
                wqriver.setDt(DateUtil.getDateFromStr(date,AverageDateUtil.findFormat(cond)));
                sameResult.add(wqriver);
            }
        }

        return sameResult;
    }

    /**
     * 计算平均值
     * @param sameDateRes
     * @return
     */
    private static Wqriver calculate(List<Wqriver> sameDateRes){
        if(sameDateRes.size()>0) {
            String staid = null;
            Double totalwatertemp = 0d;
            Double totalph = 0d;
            Double totaldox = 0d;
            Double totalcodmn = 0d;
            Double totalcodcr = 0d;
            Double totalbod5 = 0d;
            Double totalnh4 = 0d;
            Double totaltp = 0d;
            Double totaltn = 0d;
            Double totalcu = 0d;
            Double totalzn = 0d;
            Double totalf = 0d;
            Double totalsa = 0d;
            Double totalarsenic = 0d;
            Double totalhg = 0d;
            Double totalcd = 0d;
            Double totalcr = 0d;
            Double totalpb = 0d;
            Double totalcyanide = 0d;
            Double totalvp = 0d;
            Double totalpetroleum = 0d;
            Double totalasurfactant = 0d;
            Double totalsulphide = 0d;
            Double totaldibg = 0d;
            Double totalchla = 0d;
            Double totalwcond = 0d;
            Double totaltransp = 0d;
            Double totalno3N = 0d;
            Double totalpo4P = 0d;
            Double totaltss = 0d;
            Double totalso4 = 0d;
            Double totalchloride = 0d;
            Double totalhno3 = 0d;
            Double totalfe = 0d;
            Double totalmn = 0d;
            Double totaltoc = 0d;
            Double totalftu = 0d;
            for (Wqriver wqriver : sameDateRes) {
                staid = wqriver.getStaid();
                // System.err.println("Ex---"+wqriver.getWatertemp());
                totalwatertemp +=EmptySentence.judeEmpty(wqriver.getWatertemp());
                totalph += EmptySentence.judeEmpty(wqriver.getPh());
                totaldox +=EmptySentence.judeEmpty(wqriver.getDox());
                totalcodmn += EmptySentence.judeEmpty(wqriver.getCodmn());
                totalcodcr +=EmptySentence.judeEmpty(wqriver.getCodcr());
                totalbod5 += EmptySentence.judeEmpty(wqriver.getBod5());
                totalnh4 +=EmptySentence.judeEmpty(wqriver.getNh4());
                totaltp += EmptySentence.judeEmpty(wqriver.getTp());
                totaltn +=EmptySentence.judeEmpty(wqriver.getTn());
                totalcu += EmptySentence.judeEmpty(wqriver.getCu());
                totalzn +=EmptySentence.judeEmpty(wqriver.getZn());
                totalf += EmptySentence.judeEmpty(wqriver.getF());
                totalsa +=EmptySentence.judeEmpty(wqriver.getSa());
                totalarsenic +=EmptySentence.judeEmpty(wqriver.getArsenic());
                totalhg += EmptySentence.judeEmpty(wqriver.getHg());
                totalcd +=EmptySentence.judeEmpty(wqriver.getCd());
                totalcr += EmptySentence.judeEmpty(wqriver.getCr());
                totalpb +=EmptySentence.judeEmpty(wqriver.getPb());
                totalcyanide += EmptySentence.judeEmpty(wqriver.getCyanide());
                totalvp +=EmptySentence.judeEmpty(wqriver.getVp());
                totalpetroleum += EmptySentence.judeEmpty(wqriver.getPetroleum());
                totalasurfactant +=EmptySentence.judeEmpty(wqriver.getAsurfactant());
                totalsulphide += EmptySentence.judeEmpty(wqriver.getSulphide());
                totaldibg +=EmptySentence.judeEmpty(wqriver.getDibg());
                totalchla += EmptySentence.judeEmpty(wqriver.getChla());
                totalwcond +=EmptySentence.judeEmpty(wqriver.getWcond());
                totaltransp += EmptySentence.judeEmpty(wqriver.getTransp());
                totalno3N +=EmptySentence.judeEmpty(wqriver.getNo3N());
                totalpo4P += EmptySentence.judeEmpty(wqriver.getPo4P());
                totaltss +=EmptySentence.judeEmpty(wqriver.getTss());
                totalso4 += EmptySentence.judeEmpty(wqriver.getSo4());
                totalchloride +=EmptySentence.judeEmpty(wqriver.getChloride());
                totalhno3 += EmptySentence.judeEmpty(wqriver.getHno3());
                totalfe +=EmptySentence.judeEmpty(wqriver.getFe());
                totalmn += EmptySentence.judeEmpty(wqriver.getMn());
                totaltoc +=EmptySentence.judeEmpty(wqriver.getToc());
                totalftu += EmptySentence.judeEmpty(wqriver.getFtu());
                //System.out.println();
            }
            Double averwatertemp = totalwatertemp/sameDateRes.size();
            Double averph = totalph/sameDateRes.size();
            Double averdox = totaldox/sameDateRes.size();
            Double avercodmn = totalcodmn/sameDateRes.size();
            Double avercodcr = totalcodcr/sameDateRes.size();
            Double averbod5 = totalbod5/sameDateRes.size();
            Double avernh4 = totalnh4/sameDateRes.size();
            Double avertp = totaltp/sameDateRes.size();
            Double avertn = totaltn/sameDateRes.size();
            Double avercu = totalcu/sameDateRes.size();
            Double averzn = totalzn/sameDateRes.size();
            Double averf = totalf/sameDateRes.size();
            Double aversa = totalsa/sameDateRes.size();
            Double averarsenic = totalarsenic/sameDateRes.size();
            Double averhg = totalhg/sameDateRes.size();
            Double avercd = totalcd/sameDateRes.size();
            Double avercr = totalcr/sameDateRes.size();
            Double averpb = totalpb/sameDateRes.size();
            Double avercyanide = totalcyanide/sameDateRes.size();
            Double avervp = totalvp/sameDateRes.size();
            Double averpetroleum = totalpetroleum/sameDateRes.size();
            Double averasurfactant = totalasurfactant/sameDateRes.size();
            Double aversulphide = totalsulphide/sameDateRes.size();
            Double averdibg = totaldibg/sameDateRes.size();
            Double averchla = totalchla/sameDateRes.size();
            Double averwcond = totalwcond/sameDateRes.size();
            Double avertransp = totaltransp/sameDateRes.size();
            Double averno3N = totalno3N/sameDateRes.size();
            Double averpo4P = totalpo4P/sameDateRes.size();
            Double avertss = totaltss/sameDateRes.size();
            Double averso4 = totalso4/sameDateRes.size();
            Double averchloride = totalchloride/sameDateRes.size();
            Double averhno3 = totalhno3/sameDateRes.size();
            Double averfe = totalfe/sameDateRes.size();
            Double avermn = totalmn/sameDateRes.size();
            Double avertoc = totaltoc/sameDateRes.size();
            Double averftu = totalftu/sameDateRes.size();
            Wqriver wqriver = new Wqriver();
            wqriver.setWatertemp(new BigDecimal(averwatertemp));
            wqriver.setPh(new BigDecimal(averph));
            wqriver.setDox(new BigDecimal(averdox));
            wqriver.setCodmn(new BigDecimal(avercodmn));
            wqriver.setCodcr(new BigDecimal(avercodcr));
            wqriver.setBod5(new BigDecimal(averbod5));
            wqriver.setNh4(new BigDecimal(avernh4));
            wqriver.setTp(new BigDecimal(avertp));
            wqriver.setTn(new BigDecimal(avertn));
            wqriver.setCu(new BigDecimal(avercu));
            wqriver.setZn(new BigDecimal(averzn));
            wqriver.setF(new BigDecimal(averf));
            wqriver.setSa(new BigDecimal(aversa));
            wqriver.setArsenic(new BigDecimal(averarsenic));
            wqriver.setHg(new BigDecimal(averhg));
            wqriver.setCd(new BigDecimal(avercd));
            wqriver.setCr(new BigDecimal(avercr));
            wqriver.setPb(new BigDecimal(averpb));
            wqriver.setCyanide(new BigDecimal(avercyanide));
            wqriver.setVp(new BigDecimal(avervp));
            wqriver.setPetroleum(new BigDecimal(averpetroleum));
            wqriver.setAsurfactant(new BigDecimal(averasurfactant));
            wqriver.setSulphide(new BigDecimal(aversulphide));
            wqriver.setDibg(new BigDecimal(averdibg));
            wqriver.setChla(new BigDecimal(averchla));
            wqriver.setWcond(new BigDecimal(averwcond));
            wqriver.setTransp(new BigDecimal(avertransp));
            wqriver.setNo3N(new BigDecimal(averno3N));
            wqriver.setPo4P(new BigDecimal(averpo4P));
            wqriver.setTss(new BigDecimal(avertss));
            wqriver.setSo4(new BigDecimal(averso4));
            wqriver.setChloride(new BigDecimal(averchloride));
            wqriver.setHno3(new BigDecimal(averhno3));
            wqriver.setFe(new BigDecimal(averfe));
            wqriver.setMn(new BigDecimal(avermn));
            wqriver.setToc(new BigDecimal(avertoc));
            wqriver.setFtu(new BigDecimal(averftu));
            wqriver.setStaid(staid);
            return wqriver;
        }
        return  null;
    }

    public List<Wqriver> findByCond(String strCond , int type){
        Condition condition = new Condition(Wqriver.class,false,false);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("dt",DateUtil.getStrFromDate(new Date(),"yyyy-MM-01"));
        List<Wqriver> wqriverList = wqriverMapper.selectByCondition(condition);
        List<Wqriver> resList = new ArrayList<>();
        try {
            for (Wqriver wqriver : wqriverList){
                if (UseCondOfHyWq.usecond(strCond,type,wqriver)){
                    resList.add(wqriver);
                }
            }
            return resList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /*public static void main(String[] args){
        System.err.println("--"+CondOfHyWq.DOX);
        System.err.println("--"+DateUtil.getStrFromDate(new Date(),"yyyy-MM-01"));
    }*/
}
