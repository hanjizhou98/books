package com.wzl.books.mapper;

import com.wzl.books.entity.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ParamMapper {

    void addParam(Param param);

    void updateParamById(String id);

    Param findParamByName(String name);

}
