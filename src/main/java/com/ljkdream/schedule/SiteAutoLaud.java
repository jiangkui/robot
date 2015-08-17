package com.ljkdream.schedule;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 星期衣自动点赞
 * Created by LJK on 2015/8/17.
 */
@Component()
@Lazy(value = false)
public class SiteAutoLaud {

    public static final String list = "http://www.xing71.com/web/getindexdatas.json?start=10&size=20&tpid=-1&_=1439805729366";
    public static final String laud = "http://www.xing71.com/ivenus/laud.json?type=260&tid=10354&uid=11806706&token=w6TrMZ5dhQpGOmNn";

    /**
     * 自动点赞
     *
     * 每天 早上8点 自动点赞。
     *
     * 点赞成功后，记录到表中。 研究下发邮件。
     */
//    @Scheduled(fixedDelay = 30000)
    @Scheduled(cron = "0 5 0 * * ?")
    public void tomorrowOpenTaskStepUpdate() {

    }
}
