package com.xingyun.service.impl;

import com.xingyun.dao.HyriverMapper;
import com.xingyun.model.Hylake;
import com.xingyun.model.Hyriver;
import com.xingyun.service.HyriverService;
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
public class HyriverServiceImpl extends AbstractService<Hyriver> implements HyriverService {
    @Resource
    private HyriverMapper hyriverMapper;

    @Override
    public List<Hyriver> averDate(List<Hyriver> models, List<String> dateList, String cond) {
        List<Hyriver> sameResult = new ArrayList<>();
        for (int i = 0; i < dateList.size(); i++) {
            String date = dateList.get(i);
            List<Hyriver> sameDateRes = new ArrayList<>();
            for(Hyriver hyriver : models){
                Date strDate = hyriver.getDt();
                boolean fsame = AverageDateUtil.findSame(cond,strDate,date);
                if(fsame){
                    sameDateRes.add(hyriver);
                }
            }
            System.err.println("sameDateRes.size="+sameDateRes.size());
            if(sameDateRes.size()>0) {
                Double totalWaterLevel = 0d;
                Double totalDischarge = 0d;
                Double totalVelocity = 0d;
                for (Hyriver hyriver : sameDateRes) {
                    totalWaterLevel += EmptySentence.judeEmpty(hyriver.getWaterlevel());
                    totalDischarge += EmptySentence.judeEmpty(hyriver.getDischarge());
                    totalVelocity += EmptySentence.judeEmpty(hyriver.getVelocity());
                }
                Double averWaterLevel = totalWaterLevel / sameDateRes.size();
                Double averDischarge = totalDischarge / sameDateRes.size();
                Double averVelocity = totalVelocity / sameDateRes.size();
                Hyriver hyriver = new Hyriver();
                hyriver.setWaterlevel(new BigDecimal(averWaterLevel));
                hyriver.setDischarge(new BigDecimal(averDischarge));
                hyriver.setVelocity(new BigDecimal(averVelocity));
                hyriver.setDt(DateUtil.getDateFromStr(date,AverageDateUtil.findFormat(cond)));
                hyriver.setStaid(sameDateRes.get(0).getStaid());
                sameResult.add(hyriver);
            }
        }

        return sameResult;
    }
}
