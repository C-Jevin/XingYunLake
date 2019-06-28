package com.xingyun.service;
import com.xingyun.model.Wqriver;
import com.xingyun.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2019/06/17.
 */
public interface WqriverService extends Service<Wqriver> {
    List<Wqriver> findByCond(String strCond , int type);
}
