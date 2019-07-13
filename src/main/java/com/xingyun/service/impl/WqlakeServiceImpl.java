package com.xingyun.service.impl;

import com.xingyun.core.UseCondOfHyWq;
import com.xingyun.dao.WqlakeMapper;
import com.xingyun.model.Wqlake;
import com.xingyun.model.Wqlake;
import com.xingyun.model.Wqriver;
import com.xingyun.service.WqlakeService;
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
public class WqlakeServiceImpl extends AbstractService<Wqlake> implements WqlakeService {
    @Resource
    private WqlakeMapper wqlakeMapper;

    @Override
    public List<Wqlake> averDate(List<Wqlake> models,List<String> dateList,String cond) {
        List<Wqlake> sameResult = new ArrayList<>();
        for (int i = 0; i < dateList.size(); i++) {
            String date = dateList.get(i);
            List<Wqlake> sameDateRes = new ArrayList<>();
            for(Wqlake wqlake : models){
                Date strDate = wqlake.getDt();
                boolean fsame = AverageDateUtil.findSame(cond,strDate,date);
                if(fsame){
                    sameDateRes.add(wqlake);
                }
            }
            System.err.println("sameDateRes.size="+sameDateRes.size());
            if(sameDateRes.size()>0) {
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
                for (Wqlake wqlake : sameDateRes) {
                    totalwatertemp +=EmptySentence.judeEmpty(wqlake.getWatertemp());
                    totalph += EmptySentence.judeEmpty(wqlake.getPh());
                    totaldox +=EmptySentence.judeEmpty(wqlake.getDox());
                    totalcodmn += EmptySentence.judeEmpty(wqlake.getCodmn());
                    totalcodcr +=EmptySentence.judeEmpty(wqlake.getCodcr());
                    totalbod5 += EmptySentence.judeEmpty(wqlake.getBod5());
                    totalnh4 +=EmptySentence.judeEmpty(wqlake.getNh4());
                    totaltp += EmptySentence.judeEmpty(wqlake.getTp());
                    totaltn +=EmptySentence.judeEmpty(wqlake.getTn());
                    totalcu += EmptySentence.judeEmpty(wqlake.getCu());
                    totalzn +=EmptySentence.judeEmpty(wqlake.getZn());
                    totalf += EmptySentence.judeEmpty(wqlake.getF());
                    totalsa +=EmptySentence.judeEmpty(wqlake.getSa());
                    totalarsenic +=EmptySentence.judeEmpty(wqlake.getArsenic());
                    totalhg += EmptySentence.judeEmpty(wqlake.getHg());
                    totalcd +=EmptySentence.judeEmpty(wqlake.getCd());
                    totalcr += EmptySentence.judeEmpty(wqlake.getCr());
                    totalpb +=EmptySentence.judeEmpty(wqlake.getPb());
                    totalcyanide += EmptySentence.judeEmpty(wqlake.getCyanide());
                    totalvp +=EmptySentence.judeEmpty(wqlake.getVp());
                    totalpetroleum += EmptySentence.judeEmpty(wqlake.getPetroleum());
                    totalasurfactant +=EmptySentence.judeEmpty(wqlake.getAsurfactant());
                    totalsulphide += EmptySentence.judeEmpty(wqlake.getSulphide());
                    totaldibg +=EmptySentence.judeEmpty(wqlake.getDibg());
                    totalchla += EmptySentence.judeEmpty(wqlake.getChla());
                    totalwcond +=EmptySentence.judeEmpty(wqlake.getWcond());
                    totaltransp += EmptySentence.judeEmpty(wqlake.getTransp());
                    totalno3N +=EmptySentence.judeEmpty(wqlake.getNo3N());
                    totalpo4P += EmptySentence.judeEmpty(wqlake.getPo4P());
                    totaltss +=EmptySentence.judeEmpty(wqlake.getTss());
                    totalso4 += EmptySentence.judeEmpty(wqlake.getSo4());
                    totalchloride +=EmptySentence.judeEmpty(wqlake.getChloride());
                    totalhno3 += EmptySentence.judeEmpty(wqlake.getHno3());
                    totalfe +=EmptySentence.judeEmpty(wqlake.getFe());
                    totalmn += EmptySentence.judeEmpty(wqlake.getMn());
                    totaltoc +=EmptySentence.judeEmpty(wqlake.getToc());
                    totalftu += EmptySentence.judeEmpty(wqlake.getFtu());

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
                Wqlake wqlake = new Wqlake();
                wqlake.setWatertemp(new BigDecimal(averwatertemp));
                wqlake.setPh(new BigDecimal(averph));
                wqlake.setDox(new BigDecimal(averdox));
                wqlake.setCodmn(new BigDecimal(avercodmn));
                wqlake.setCodcr(new BigDecimal(avercodcr));
                wqlake.setBod5(new BigDecimal(averbod5));
                wqlake.setNh4(new BigDecimal(avernh4));
                wqlake.setTp(new BigDecimal(avertp));
                wqlake.setTn(new BigDecimal(avertn));
                wqlake.setCu(new BigDecimal(avercu));
                wqlake.setZn(new BigDecimal(averzn));
                wqlake.setF(new BigDecimal(averf));
                wqlake.setSa(new BigDecimal(aversa));
                wqlake.setArsenic(new BigDecimal(averarsenic));
                wqlake.setHg(new BigDecimal(averhg));
                wqlake.setCd(new BigDecimal(avercd));
                wqlake.setCr(new BigDecimal(avercr));
                wqlake.setPb(new BigDecimal(averpb));
                wqlake.setCyanide(new BigDecimal(avercyanide));
                wqlake.setVp(new BigDecimal(avervp));
                wqlake.setPetroleum(new BigDecimal(averpetroleum));
                wqlake.setAsurfactant(new BigDecimal(averasurfactant));
                wqlake.setSulphide(new BigDecimal(aversulphide));
                wqlake.setDibg(new BigDecimal(averdibg));
                wqlake.setChla(new BigDecimal(averchla));
                wqlake.setWcond(new BigDecimal(averwcond));
                wqlake.setTransp(new BigDecimal(avertransp));
                wqlake.setNo3N(new BigDecimal(averno3N));
                wqlake.setPo4P(new BigDecimal(averpo4P));
                wqlake.setTss(new BigDecimal(avertss));
                wqlake.setSo4(new BigDecimal(averso4));
                wqlake.setChloride(new BigDecimal(averchloride));
                wqlake.setHno3(new BigDecimal(averhno3));
                wqlake.setFe(new BigDecimal(averfe));
                wqlake.setMn(new BigDecimal(avermn));
                wqlake.setToc(new BigDecimal(avertoc));
                wqlake.setFtu(new BigDecimal(averftu));
                wqlake.setDt(DateUtil.getDateFromStr(date,AverageDateUtil.findFormat(cond)));
                wqlake.setStaid(sameDateRes.get(0).getStaid());
                sameResult.add(wqlake);
            }
        }

        return sameResult;
    }

    @Override
    public List<Wqlake> findByCond(String strCond, int type) {
        Condition condition = new Condition(Wqlake.class,false,false);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("dt",DateUtil.getStrFromDate(new Date(),"yyyy-MM-01"));
        List<Wqlake> wqlakeList = wqlakeMapper.selectByCondition(condition);
        List<Wqlake> resList = new ArrayList<>();
        try {
            for (Wqlake wqlake : wqlakeList){
                if (UseCondOfHyWq.usecond(strCond,type,wqlake)){
                    resList.add(wqlake);
                }
            }
            return resList;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
