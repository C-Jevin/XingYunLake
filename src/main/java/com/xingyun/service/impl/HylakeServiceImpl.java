package com.xingyun.service.impl;

import com.xingyun.dao.HylakeMapper;
import com.xingyun.model.Hylake;
import com.xingyun.service.HylakeService;
import com.xingyun.core.AbstractService;
import com.xingyun.util.AverageDateUtil;
import com.xingyun.util.DateUtil;
import com.xingyun.util.EmptySentence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class HylakeServiceImpl extends AbstractService<Hylake> implements HylakeService {
    @Resource
    private HylakeMapper hylakeMapper;

    @Override
    public List<Hylake> averDate(List<Hylake> models,List<String> dateList,String cond) {
        List<Hylake> sameResult = new ArrayList<>();
        for (int i = 0; i < dateList.size(); i++) {
            String date = dateList.get(i);
            List<Hylake> sameDateRes = new ArrayList<>();
            for(Hylake hylake : models){
                Date strDate = hylake.getDt();
                boolean fsame = AverageDateUtil.findSame(cond,strDate,date);
                if(fsame){
                    sameDateRes.add(hylake);
                }
            }
            System.err.println("sameDateRes.size="+sameDateRes.size());
            if(sameDateRes.size()>0) {
                Double totalWaterLevel = 0d;
                Double totalVolume = 0d;
                for (Hylake hylake : sameDateRes) {
                    totalWaterLevel +=EmptySentence.judeEmpty(hylake.getWaterlevel());
                    totalVolume += EmptySentence.judeEmpty(hylake.getVolume());
                }
                Double averWaterLevel = totalWaterLevel / sameDateRes.size();
                Double averVolume = totalVolume / sameDateRes.size();
                Hylake hylake = new Hylake();
                hylake.setWaterlevel(new BigDecimal(averWaterLevel));
                hylake.setVolume(new BigDecimal(averVolume));
                hylake.setDt(DateUtil.getDateFromStr(date,AverageDateUtil.findFormat(cond)));
                hylake.setStaid(sameDateRes.get(0).getStaid());
                sameResult.add(hylake);
            }
        }

        return sameResult;
    }
}
