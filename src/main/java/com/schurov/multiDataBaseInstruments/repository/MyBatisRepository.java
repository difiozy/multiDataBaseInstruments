package com.schurov.multiDataBaseInstruments.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyBatisRepository {

    @Select("""
            select * from test_entity te where te.id = #{id}
            """)
    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "value", property = "value")
    }, id = "fullTestEntity")
    TestEntity findById(Long id);
}
