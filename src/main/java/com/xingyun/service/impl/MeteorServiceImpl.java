package com.xingyun.service.impl;

import com.xingyun.dao.MeteorMapper;
import com.xingyun.model.Meteor;
import com.xingyun.model.Meteor;
import com.xingyun.model.Stationlist;
import com.xingyun.service.MeteorService;
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
import java.util.*;


/**
 * Created by CodeGenerator on 2019/06/17.
 */
@Service
@Transactional
public class MeteorServiceImpl extends AbstractService<Meteor> implements MeteorService {
    @Resource
    private MeteorMapper meteorMapper;

    /**
     * 计算气象平均值
     * @param models
     * @param dateList
     * @param cond
     * @return
     */
    @Override
    public List<Meteor> averDate(List<Meteor> models,List<String> dateList,String cond) {
        List<Meteor> sameResult = new ArrayList<>();
        for (int i = 0; i < dateList.size(); i++) {
            String date = dateList.get(i);
            List<Meteor> sameDateRes = new ArrayList<>();
            for(Meteor meteor : models){
                Date strDate = meteor.getDt();
                boolean fsame = AverageDateUtil.findSame(cond,strDate,date);
                if(fsame){
                    sameDateRes.add(meteor);
                }
            }
            System.err.println("sameDateRes.size="+sameDateRes.size());
            /*if(sameDateRes.size()>0) {
                Double totalpressure = 0d;
                Double totaltemperature = 0d;
                Double totalhumidity = 0d;
                Double totalprep = 0d;
                Double totalwindspeed = 0d;
                Double totalwinddirect = 0d;
                Double totalsolrad = 0d;
                Double totaleva = 0d;
                Double totalcloud = 0d;
                for (Meteor Meteor : sameDateRes) {
                    totalpressure +=EmptySentence.judeEmpty(Meteor.getPressure());
                    totaltemperature += EmptySentence.judeEmpty(Meteor.getTemperature());
                    totalhumidity +=EmptySentence.judeEmpty(Meteor.getHumidity());
                    totalprep += EmptySentence.judeEmpty(Meteor.getPrep());
                    totalwindspeed +=EmptySentence.judeEmpty(Meteor.getWindspeed());
                    totalwinddirect += EmptySentence.judeEmpty(Meteor.getWinddirect());
                    totalsolrad +=EmptySentence.judeEmpty(Meteor.getSolrad());
                    totaleva += EmptySentence.judeEmpty(Meteor.getEva());
                    totalcloud +=EmptySentence.judeEmpty(Meteor.getCloud());
                }
                Double averpressure = totalpressure / sameDateRes.size();
                Double avertemperature  = totaltemperature / sameDateRes.size();
                Double averhumidity = totalhumidity / sameDateRes.size();
                Double avermeteorfall = totalprep / sameDateRes.size();
                Double averwindspeed = totalwindspeed / sameDateRes.size();
                Double averwinddirect = totalwinddirect / sameDateRes.size();
                Double aversolrad = totalsolrad / sameDateRes.size();
                Double avereva = totaleva / sameDateRes.size();
                Double avercloud = totalcloud / sameDateRes.size();
                Meteor meteor = new Meteor();
                meteor.setPressure(new BigDecimal(averpressure));
                meteor.setTemperature(new BigDecimal(avertemperature));
                meteor.setHumidity(new BigDecimal(averhumidity));
                meteor.setPrep(new BigDecimal(avermeteorfall));
                meteor.setWindspeed(new BigDecimal(averwindspeed));
                meteor.setWinddirect(new BigDecimal(averwinddirect));
                meteor.setSolrad(new BigDecimal(aversolrad));
                meteor.setEva(new BigDecimal(avereva));
                meteor.setCloud(new BigDecimal(avercloud));
                meteor.setDt(DateUtil.getDateFromStr(date,AverageDateUtil.findFormat(cond)));
                meteor.setStaid(sameDateRes.get(0).getStaid());
                sameResult.add(meteor);
            }*/
            Meteor meteor = calculate(sameDateRes);
            if(meteor!=null){
                meteor.setDt(DateUtil.getDateFromStr(date,AverageDateUtil.findFormat(cond)));
                sameResult.add(meteor);
            }
        }

        return sameResult;
    }

    private static Meteor calculate(List<Meteor> sameDateRes){
        Double totalpressure = 0d;
        Double totaltemperature = 0d;
        Double totalhumidity = 0d;
        Double totalprep = 0d;
        Double totalwindspeed = 0d;
        Double totalwinddirect = 0d;
        Double totalsolrad = 0d;
        Double totaleva = 0d;
        Double totalcloud = 0d;
        if(sameDateRes.size()>0) {
            for (Meteor Meteor : sameDateRes) {
                totalpressure +=EmptySentence.judeEmpty(Meteor.getPressure());
                totaltemperature += EmptySentence.judeEmpty(Meteor.getTemperature());
                totalhumidity +=EmptySentence.judeEmpty(Meteor.getHumidity());
                totalprep += EmptySentence.judeEmpty(Meteor.getPrep());
                totalwindspeed +=EmptySentence.judeEmpty(Meteor.getWindspeed());
                totalwinddirect += EmptySentence.judeEmpty(Meteor.getWinddirect());
                totalsolrad +=EmptySentence.judeEmpty(Meteor.getSolrad());
                totaleva += EmptySentence.judeEmpty(Meteor.getEva());
                totalcloud +=EmptySentence.judeEmpty(Meteor.getCloud());
            }
            Double averpressure = totalpressure / sameDateRes.size();
            Double avertemperature  = totaltemperature / sameDateRes.size();
            Double averhumidity = totalhumidity / sameDateRes.size();
            Double averprep = totalprep / sameDateRes.size();
            Double averwindspeed = totalwindspeed / sameDateRes.size();
            Double averwinddirect = totalwinddirect / sameDateRes.size();
            Double aversolrad = totalsolrad / sameDateRes.size();
            Double avereva = totaleva / sameDateRes.size();
            Double avercloud = totalcloud / sameDateRes.size();
            Meteor meteor = new Meteor();
            meteor.setPressure(new BigDecimal(averpressure));
            meteor.setTemperature(new BigDecimal(avertemperature));
            meteor.setHumidity(new BigDecimal(averhumidity));
            meteor.setPrep(new BigDecimal(averprep));
            meteor.setWindspeed(new BigDecimal(averwindspeed));
            meteor.setWinddirect(new BigDecimal(averwinddirect));
            meteor.setSolrad(new BigDecimal(aversolrad));
            meteor.setEva(new BigDecimal(avereva));
            meteor.setCloud(new BigDecimal(avercloud));
            //meteor.setDt(DateUtil.getDateFromStr(date,AverageDateUtil.findFormat(cond)));
            meteor.setStaid(sameDateRes.get(0).getStaid());
            //sameResult.add(meteor);
            return meteor;
        }
        return null;
    }

    public List<Meteor> findByPrepAndDt(String meteorType){
        String endTime = DateUtil.getStrFromDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        String startTime = DateUtil.getStrFromDate(new Date(),"yyyy-MM-dd 00:00:00");
        Condition condition = new Condition(Meteor.class,false,false);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andBetween("dt",startTime,endTime);
        List<Meteor> meteorList = meteorMapper.selectByCondition(condition);
        Set<String> set=new HashSet();

        List<Meteor> staIdList = new ArrayList<>();
        for (Meteor meteor : meteorList){
            set.add(meteor.getStaid());
        }
        //根据staid拆分
        for(String staid : set){
            List<Meteor> sameList = new ArrayList<>();
            for(Meteor meteor : meteorList) {
                if (meteor.getStaid().equals(staid)) {
                    sameList.add(meteor);
                }
            }
            if (sameList.size() >0) {
                Meteor tMeteor = new Meteor();
                Double totalprep =0d;
                String staId = null;
                for (Meteor meteor : sameList) {
                    totalprep += EmptySentence.judeEmpty(meteor.getPrep());
                    staId = meteor.getStaid();
                }
                tMeteor.setPrep(new BigDecimal(totalprep));
                tMeteor.setStaid(staId);
                if (meteorType.equals("xy")) {//小雨
                    if (totalprep < 10d) {
                        staIdList.add(tMeteor);
                    }
                } else if (meteorType.equals("zy")) {//中雨
                    if (totalprep >= 10d && totalprep < 25d) {
                        staIdList.add(tMeteor);
                    }
                } else if (meteorType.equals("dy")) {//大雨
                    if (totalprep  >= 25d && totalprep  < 50d) {
                        staIdList.add(tMeteor);
                    }
                } else if (meteorType.equals("by")) {//暴雨
                    if (totalprep  >= 50d && totalprep  < 100d) {
                        staIdList.add(tMeteor);
                    }
                } else if (meteorType.equals("dby")) {//大暴雨
                    if (totalprep  >= 100d && totalprep  < 250d) {
                        staIdList.add(tMeteor);
                    }
                } else if (meteorType.equals("tdby")) {//特大暴雨
                    if (totalprep  >= 250d) {
                        staIdList.add(tMeteor);
                    }
                }
            }
        }
        return staIdList;
    }
}
