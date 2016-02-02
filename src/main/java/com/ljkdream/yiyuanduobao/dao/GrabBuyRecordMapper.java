package com.ljkdream.yiyuanduobao.dao;

import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GrabBuyRecordMapper {
    int countByExample(GrabBuyRecordExample example);

    int deleteByExample(GrabBuyRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GrabBuyRecord record);

    int insertSelective(GrabBuyRecord record);

    List<GrabBuyRecord> selectByExample(GrabBuyRecordExample example);

    GrabBuyRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GrabBuyRecord record, @Param("example") GrabBuyRecordExample example);

    int updateByExample(@Param("record") GrabBuyRecord record, @Param("example") GrabBuyRecordExample example);

    int updateByPrimaryKeySelective(GrabBuyRecord record);

    int updateByPrimaryKey(GrabBuyRecord record);
}