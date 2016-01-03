package com.ljkdream.dao;

import com.ljkdream.model.PeriodWinner;
import com.ljkdream.model.PeriodWinnerExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface PeriodWinnerMapper {
    int countByExample(PeriodWinnerExample example);

    int deleteByExample(PeriodWinnerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PeriodWinner record);

    int insertSelective(PeriodWinner record);

    List<PeriodWinner> selectByExample(PeriodWinnerExample example);

    PeriodWinner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PeriodWinner record, @Param("example") PeriodWinnerExample example);

    int updateByExample(@Param("record") PeriodWinner record, @Param("example") PeriodWinnerExample example);

    int updateByPrimaryKeySelective(PeriodWinner record);

    int updateByPrimaryKey(PeriodWinner record);
}