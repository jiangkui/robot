package com.ljkdream.task.yiyuanduobao;

import com.ljkdream.service.YiYuanDuoBaoService;
import com.ljkdream.task.base.AbstractBaseTask;

/**
 * 抓取所有商品任务
 * Created by ljk on 16-1-4.
 */
public class AllGoodsTask extends AbstractBaseTask {

    //http://1.163.com/list/0-0-1-1.html ~ http://1.163.com/list/0-0-1-10.html 共10页
    public static final String BASE_URL = "http://1.163.com/list/0-0-1-";

    private YiYuanDuoBaoService yiYuanDuoBaoService;
    private int page = 1;

    public AllGoodsTask(YiYuanDuoBaoService yiYuanDuoBaoService, int page) {
        this.yiYuanDuoBaoService = yiYuanDuoBaoService;
        this.page = page;
    }

    @Override
    public void execute() {

    }

    private String obtainUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL).append(page).append(".html");
        return sb.toString();
    }
}
