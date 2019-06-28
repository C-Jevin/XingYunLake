package com.xingyun.service.impl;

import com.xingyun.dao.StationlistMapper;
import com.xingyun.model.Stationlist;
import com.xingyun.service.StationlistService;
import com.xingyun.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/06/17.
 */
@Service
@Transactional
public class StationlistServiceImpl extends AbstractService<Stationlist> implements StationlistService {
    @Resource
    private StationlistMapper stationlistMapper;

    @Override
    public List<Stationlist> averDate(List<Stationlist> models,List<String> dateList,String cond) {
        return null;
    }
}
