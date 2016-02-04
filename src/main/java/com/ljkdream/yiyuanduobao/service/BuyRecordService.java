package com.ljkdream.yiyuanduobao.service;

import com.ljkdream.yiyuanduobao.dao.BuyRecordMapper;
import com.ljkdream.yiyuanduobao.model.BuyRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 抓取记录service
 * Created by jiangkui on 16-2-4.
 */
@Service
public class BuyRecordService {

    @Autowired
    private BuyRecordMapper buyRecordMapper;

    public void insertByList(List<BuyRecord> buyRecordList) {
        buyRecordMapper.insertBuyRecordList(buyRecordList);
    }
}
