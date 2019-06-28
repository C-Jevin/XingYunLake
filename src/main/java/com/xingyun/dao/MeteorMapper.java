package com.xingyun.dao;

import com.xingyun.core.Mapper;
import com.xingyun.model.Meteor;
import org.springframework.stereotype.Repository;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface MeteorMapper extends Mapper<Meteor> {
}