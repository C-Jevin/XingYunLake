package com.xingyun.service.impl;

import com.xingyun.dao.RainMapper;
import com.xingyun.model.Rain;
import com.xingyun.model.Rain;
import com.xingyun.service.RainService;
import com.xingyun.core.AbstractService;
import com.xingyun.util.AverageDateUtil;
import com.xingyun.util.DateUtil;
import com.xingyun.util.EmptySentence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;


/**
 * Created by CodeGenerator on 2019/06/17.
 */
@Service
@Transactional
public class RainServiceImpl extends AbstractService<Rain> implements RainService {
    @Resource
    private RainMapper rainMapper;

    /**
     * 计算平均值
     * @param models
     * @param dateList
     * @param cond
     * @return
     */
    @Override
    public List<Rain> averDate(List<Rain> models,List<String> dateList,String cond) {
        List<Rain> sameResult = new ArrayList<>();
        for (int i = 0; i < dateList.size(); i++) {
            String date = dateList.get(i);
            List<Rain> sameDateRes = new ArrayList<>();
            for(Rain rain : models){
                Date strDate = rain.getDt();
                boolean fsame = AverageDateUtil.findSame(cond,strDate,date);
                if(fsame){
                    sameDateRes.add(rain);
                }
            }
            System.err.println("sameDateRes.size="+sameDateRes.size());
            /*if(sameDateRes.size()>0) {
                Double totalprep = 0d;
                for (Rain rain : sameDateRes) {
                    totalprep +=EmptySentence.judeEmpty(rain.getPrep());
                }
                //Double averprep = totalprep / sameDateRes.size();
                Rain rain = new Rain();
                rain.setPrep(new BigDecimal(totalprep));
                rain.setDt(DateUtil.getDateFromStr(date,AverageDateUtil.findFormat(cond)));
                rain.setStaid(sameDateRes.get(0).getStaid());
                sameResult.add(rain);
            }*/
            Rain rain = calculate(sameDateRes);
            if(rain!=null) {
                rain.setDt(DateUtil.getDateFromStr(date,AverageDateUtil.findFormat(cond)));
                sameResult.add(rain);
            }
        }
        return sameResult;
    }

    /**
     * 计算累加和
     * @param sameDateRes
     * @return
     */
    private static Rain calculate(List<Rain> sameDateRes){
        if(sameDateRes.size()>0) {
            Double totalprep = 0d;
            String staid = null;
            for (Rain rain : sameDateRes) {
                totalprep +=EmptySentence.judeEmpty(rain.getPrep());
                staid = rain.getStaid();
            }
            Rain rain = new Rain();
            rain.setPrep(new BigDecimal(totalprep));
            rain.setStaid(staid);
            return rain;
        }
        return null;
    }
    /**
     * 查询当天降雨量
     * @param rainType
     * @return
     */
    public  List<Rain> findByPrepAndDt(String rainType){
        Map<String,Object> map = new HashMap<>();
        String endTime = DateUtil.getStrFromDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        String startTime = DateUtil.getStrFromDate(new Date(),"yyyy-MM-dd 00:00:00");
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        List<Rain> rainList = rainMapper.findByPrepAndDt(map);
        Set<String> set=new HashSet();

        List<Rain> staIdList = new ArrayList<>();
        for (Rain rain : rainList){
            set.add(rain.getStaid());
        }
        for(String staid : set){
            List<Rain> sameList = new ArrayList<>();
            for(Rain rain : rainList) {
                if (rain.getStaid().equals(staid)) {
                    sameList.add(rain);
                }
            }
            Rain tRain = calculate(sameList);
            if (tRain != null) {
                if (rainType.equals("xy")) {//小雨
                    if (tRain.getPrep().doubleValue() < 10d) {
                        staIdList.add(tRain);
                    }
                } else if (rainType.equals("zy")) {//中雨
                    if (tRain.getPrep().doubleValue() >= 10d && tRain.getPrep().doubleValue() < 25d) {
                        staIdList.add(tRain);
                    }
                } else if (rainType.equals("dy")) {//大雨
                    if (tRain.getPrep().doubleValue() >= 25d && tRain.getPrep().doubleValue() < 50d) {
                        staIdList.add(tRain);
                    }
                } else if (rainType.equals("by")) {//暴雨
                    if (tRain.getPrep().doubleValue() >= 50d && tRain.getPrep().doubleValue() < 100d) {
                        staIdList.add(tRain);
                    }
                } else if (rainType.equals("dby")) {//大暴雨
                    if (tRain.getPrep().doubleValue() >= 100d && tRain.getPrep().doubleValue() < 250d) {
                        staIdList.add(tRain);
                    }
                } else if (rainType.equals("tdby")) {//特大暴雨
                    if (tRain.getPrep().doubleValue() >= 250d) {
                        staIdList.add(tRain);
                    }
                }
            }
        }
        return staIdList;
    }


}
