package com.ljkdream.task.yiyuanduobao;

import com.ljkdream.service.YiYuanDuoBaoService;
import com.ljkdream.task.base.AbstractBaseTask;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 抓取所有商品任务
 * Created by ljk on 16-1-4.
 */
public class AllGoodsTask extends AbstractBaseTask {

    //http://1.163.com/list/0-0-1-1.html ~ http://1.163.com/list/0-0-1-10.html 共10页
    public static final String BASE_URL = "http://1.163.com/list/0-0-1-";

    private static Logger logger = LoggerFactory.getLogger(AllGoodsTask.class);

    private YiYuanDuoBaoService yiYuanDuoBaoService;
    private int page = 1;

    public AllGoodsTask(YiYuanDuoBaoService yiYuanDuoBaoService, int page) {
        this.yiYuanDuoBaoService = yiYuanDuoBaoService;
        this.page = page;
    }

    @Override
    public void execute() {
        int exit = 0;
        Random random = new Random();

        while (true) {
//        for (int i = 0; i < 1; i++) {
            String obtainUrl = obtainUrl();
            logger.info("本次请求url：" + obtainUrl);
            try {
                if (exit >= 3) {
                    return;
                }

                List<String> linkList = obtainLinkList(obtainUrl);
                if (linkList.size() < 1) {
                    exit ++;
                    page ++;
                    logger.warn("没有获取到链接！ url:" + obtainUrl);
                    continue;
                }

                Map<String, String> relationMap = obtainRelationMap(linkList);

                yiYuanDuoBaoService.saveRelationGoodsPeriodByMap(relationMap);

                page ++;
                TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
            } catch (IOException e) {
                exit ++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Map<String, String> obtainRelationMap(List<String> linkList) {
        Map<String, String> relationMap = new HashMap<>();

        for (String link : linkList) {
            int start = link.lastIndexOf("/") + 1;
            int end = link.lastIndexOf(".");

            String relation = link.substring(start, end);

            String[] split = relation.split("-");

            relationMap.put(split[0], split[1]);
        }

        return relationMap;
    }

    /**
     * 获取所有商品的链接
     * @param requestUrl 请求url
     * @return list
     * @throws IOException Jsoup.connect(url).get() 在获取网页的时候如果失败，会抛出该异常
     */
    private List<String> obtainLinkList(String requestUrl) throws IOException {
        //匹配如下规则的url： http://1.163.com/detail/140-301043150.html"
        Pattern compile = Pattern.compile("^http://1\\.163\\.com/detail/\\d{2,5}\\-\\d{1,20}\\.html");

        Connection connect = Jsoup.connect(requestUrl);
        Document document = connect.get();
        Elements elementList = document.getElementsByClass("m-list-mod-bd");
        List<String> hrefList = new ArrayList<>();

        for (Element element : elementList) {
            Elements links = element.getElementsByTag("a");
            for (Element link : links) {
                String href = link.attr("href");
                if (compile.matcher(href).matches()) {
                    hrefList.add(href);
                }
            }
        }

        return hrefList;
    }

    private String obtainUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL).append(page).append(".html");
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "http://1.163.com/detail/140-301043150.html";
        Pattern compile = Pattern.compile("^http://1\\.163\\.com/detail/\\d{2,5}\\-\\d{1,20}\\.html");
        Matcher matcher = compile.matcher(str);
        System.out.println("matcher = " + matcher.matches());
    }
}
