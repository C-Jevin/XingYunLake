package com.xingyun.dao;

import com.xingyun.core.Mapper;
import com.xingyun.model.Hylake;
import org.springframework.stereotype.Repository;
//import org.apache.ibatis.annotations.Mapper;
@org.apache.ibatis.annotations.Mapper
@Repository
public interface HylakeMapper extends Mapper<Hylake> {
}