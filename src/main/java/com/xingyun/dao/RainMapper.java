package com.xingyun.dao;

import com.xingyun.core.Mapper;
import com.xingyun.model.Rain;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@org.apache.ibatis.annotations.Mapper
@Repository
public interface RainMapper extends Mapper<Rain> {
    List<Rain> findByPrepAndDt(Map<String,Object> map);
}