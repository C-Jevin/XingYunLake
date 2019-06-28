package com.xingyun.service;
import com.xingyun.model.Rain;
import com.xingyun.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2019/06/17.
 */
public interface RainService extends Service<Rain> {
    List<Rain> findByPrepAndDt(String rainType);
}
