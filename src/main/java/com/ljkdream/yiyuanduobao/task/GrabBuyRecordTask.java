package com.ljkdream.yiyuanduobao.task;

import com.ljkdream.core.task.AbstractBaseTask;
import com.ljkdream.core.util.SpringUtil;
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
    private static GrabBuyRecordService grabBuyRecordService;

    @Override
    public void initService() {
        if (grabBuyRecordService == null) {
            grabBuyRecordService = SpringUtil.getBean(GrabBuyRecordService.class);
        }
    }

    private Logger logger = LoggerFactory.getLogger(GrabBuyRecordTask.class);

    public GrabBuyRecordTask(Long period, Long gid) {
        this.period = period;
        this.gid = gid;
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
