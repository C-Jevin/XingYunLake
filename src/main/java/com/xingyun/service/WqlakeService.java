package com.xingyun.service;
import com.xingyun.model.Wqlake;
import com.xingyun.core.Service;
import com.xingyun.model.Wqriver;

import java.util.List;


/**
 * Created by CodeGenerator on 2019/06/17.
 */
public interface WqlakeService extends Service<Wqlake> {
    List<Wqlake> findByCond(String strCond , int type);
}
