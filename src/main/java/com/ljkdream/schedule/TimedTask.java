package com.ljkdream.schedule;

import com.ljkdream.schedule.producerConsumer.SingleScheduleQueueFactory;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 *
 * 固定时刻执行
 * Created by LJK on 2015/8/17.
 */
@Component()
@Lazy(value = false)
public class TimedTask {

    private static Logger logger = Logger.getLogger(TimedTask.class);

    /**
     * 自动点赞
     *
     * 每天 早上8点 自动点赞。
     *
     * 点赞成功后，记录到表中。 研究下发邮件。
     */
    @Scheduled(cron = "0 30 9 * * ?")
    public void siteAutoLaud() {
        TimedTask.siteAutoLaudstart(-1);
    }

    public static void siteAutoLaudstart(int laudNum) {
        SiteAutoLaud siteAutoLaud = new SiteAutoLaud(laudNum);

        try {
            SingleScheduleQueueFactory.getScheduleQueue().put(siteAutoLaud);
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.error("自动点赞任务异常！");
        }
    }

}
