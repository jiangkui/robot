package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.task.AbstractBaseTask;
import com.ljkdream.yiyuanduobao.model.GrabBuyRecord;
import com.ljkdream.yiyuanduobao.service.GrabBuyRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抓取购买记录 Task
 * Created by ljk on 16-2-2.
 */
public class GrabBuyRecordTask extends AbstractBaseTask {

    private Long period;
    private Long gid;
    private GrabBuyRecordService grabBuyRecordService;

    private Logger logger = LoggerFactory.getLogger(GrabBuyRecordTask.class);

    public GrabBuyRecordTask(Long period, Long gid, GrabBuyRecordService grabBuyRecordService) {
        this.period = period;
        this.gid = gid;
        this.grabBuyRecordService = grabBuyRecordService;
    }

    @Override
    public void execute() {
        GrabBuyRecord grabBuyRecord = grabBuyRecordService.queryByPeriodGid(period, gid);
        if (grabBuyRecord == null) {
            int insert = grabBuyRecordService.insert(grabBuyRecord);
            if (insert < 1) {
                logger.error("插入数据失败！");
                return;
            }
        }


    }
}
