package com.xingyun.service;
import com.xingyun.model.Meteor;
import com.xingyun.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2019/06/17.
 */
public interface MeteorService extends Service<Meteor> {
    List<Meteor> findByPrepAndDt(String meteorType);
}
