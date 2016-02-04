package com.ljkdream.yiyuanduobao.service;

import com.ljkdream.yiyuanduobao.dao.GrabBuyRecordMapper;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecordExample;
import com.ljkdream.yiyuanduobao.model.PeriodWinner;
import com.ljkdream.yiyuanduobao.schedule.PeriodWinnerSchedule;
import com.ljkdream.yiyuanduobao.task.GrabBuyRecordTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(GrabBuyRecordService.class);

    @Autowired
    private PeriodWinnerService periodWinnerService;


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

    public GrabBuyRecord obtainNextGrabTask(GrabBuyRecord grabBuyRecord) {
        PeriodWinner periodWinner = periodWinnerService.queryNext(grabBuyRecord.getGid(), grabBuyRecord.getPeriod());
        if (periodWinner == null) {
            return null;
        }

        GrabBuyRecord result = GrabBuyRecordTask.createGrabBuyRecord(periodWinner);

        return result;
    }

    public GrabBuyRecord obtainGrabTask() {
        GrabBuyRecord grabBuyRecord = queryByMax();
        if (grabBuyRecord == null) {
            PeriodWinner periodWinner = periodWinnerService.queryByMin();
            if (periodWinner == null) {
                logger.warn("没有 periodWinner 记录");
                return null;
            }
            grabBuyRecord = GrabBuyRecordTask.createGrabBuyRecord(periodWinner);
        } else {
            //已经抓取完成，则获取下一个抓取任务
            if (grabBuyRecord.getStatus() == GrabBuyRecord.STATUS_SUCCESS) {
                grabBuyRecord = obtainNextGrabTask(grabBuyRecord);
            }
        }

        return grabBuyRecord;
    }

    public boolean insertAndTry(GrabBuyRecord grabBuyRecord) {
        int insert = 0;
        int insertTry = 0;
        while (insert == 0) {
            insert = insert(grabBuyRecord);
            if (insertTry++ > 0) {
                logger.error("插入 grabBuyRecord 失败！重试：" + insertTry + grabBuyRecord);
            } else if (insertTry > 3) {
                logger.error("插入 grabBuyRecord 失败！停止任务！");
                return false;
            }
        }
        return true;
    }
}
