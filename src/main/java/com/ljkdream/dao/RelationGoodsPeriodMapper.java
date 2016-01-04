package com.ljkdream.dao;

import com.ljkdream.model.RelationGoodsPeriod;
import com.ljkdream.model.RelationGoodsPeriodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationGoodsPeriodMapper {
    int countByExample(RelationGoodsPeriodExample example);

    int deleteByExample(RelationGoodsPeriodExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RelationGoodsPeriod record);

    int insertSelective(RelationGoodsPeriod record);

    List<RelationGoodsPeriod> selectByExample(RelationGoodsPeriodExample example);

    RelationGoodsPeriod selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RelationGoodsPeriod record, @Param("example") RelationGoodsPeriodExample example);

    int updateByExample(@Param("record") RelationGoodsPeriod record, @Param("example") RelationGoodsPeriodExample example);

    int updateByPrimaryKeySelective(RelationGoodsPeriod record);

    int updateByPrimaryKey(RelationGoodsPeriod record);
}