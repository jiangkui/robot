package com.ljkdream.yiyuanduobao.service;

import com.ljkdream.yiyuanduobao.dao.GrabBuyRecordMapper;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 抓取参与记录
 * Created by jiangkui on 16-2-2.
 */
@Service
public class GrabBuyRecordService {

    @Autowired
    private GrabBuyRecordMapper grabBuyRecordMapper;


    public int insert(GrabBuyRecord grabBuyRecord) {
        int insert = grabBuyRecordMapper.insert(grabBuyRecord);
        return insert;
    }

    public GrabBuyRecord queryByPeriodGid(Long period, Long gid) {
        GrabBuyRecordExample example = new GrabBuyRecordExample();
        example.createCriteria().andPeriodEqualTo(period).andGidEqualTo(gid);

        List<GrabBuyRecord> list = grabBuyRecordMapper.selectByExample(example);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    public GrabBuyRecord queryByMax() {
        GrabBuyRecordExample example = new GrabBuyRecordExample();
        example.setOrderByClause("id desc limit 1");

        List<GrabBuyRecord> list = grabBuyRecordMapper.selectByExample(example);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
}
