package com.ljkdream.yiyuanduobao.dao;

import com.ljkdream.yiyuanduobao.model.BuyRecord;
import com.ljkdream.yiyuanduobao.model.BuyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRecordMapper {
    int countByExample(BuyRecordExample example);

    int deleteByExample(BuyRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BuyRecord record);

    int insertSelective(BuyRecord record);

    List<BuyRecord> selectByExample(BuyRecordExample example);

    BuyRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BuyRecord record, @Param("example") BuyRecordExample example);

    int updateByExample(@Param("record") BuyRecord record, @Param("example") BuyRecordExample example);

    int updateByPrimaryKeySelective(BuyRecord record);

    int updateByPrimaryKey(BuyRecord record);
}