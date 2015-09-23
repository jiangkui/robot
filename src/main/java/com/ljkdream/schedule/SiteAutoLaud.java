package com.ljkdream.schedule;

import com.ljkdream.schedule.producerConsumer.AbstractSchedule;
import com.ljkdream.util.HttpClientUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 自动点赞
 * Created by LJK on 2015/8/17.
 */
public class SiteAutoLaud extends AbstractSchedule {

    public int laudNum = 0; //点赞数量

    public static final int DEFAULT_SIZE = 20; //列表默认大小

    public static final String list = "http://www.xing71.com/web/getindexdatas.json?start=10&size=20&tpid=-1&_=1439805729366";
    public static final String laud = "http://www.xing71.com/ivenus/laud.json?type=260&tid=10354&uid=11806706&token=w6TrMZ5dhQpGOmNn";

    public static final String VENUS_LIST_URL = "http://www.xing71.com/web/getindexdatas.json";
    public static final String LAUD_VENUS_URL = "http://www.xing71.com/ivenus/laud.json";

    public SiteAutoLaud() {
    }

    public SiteAutoLaud(int laudNum) {
        this.laudNum = laudNum;
    }

    @Override
    public void execute() {

        String responseEntity = null;

        if (laudNum < 1) {
            laudNum = new Random().nextInt(5) + 2; //最点2个赞
        }

        int laudSuccessNum = 0; //点赞成功数量
        int laudCurrentNum = 0; //本次需要点赞的数量

        try {
            for (int i = 0; i < 10000; i++) {
                int start = i * DEFAULT_SIZE + 1;
                JSONObject jsonObject = this.getVenusList(start, DEFAULT_SIZE); //获取搭配图的列表

                laudCurrentNum = laudNum - laudCurrentNum; //还需要点多少个
                if (laudCurrentNum > DEFAULT_SIZE) {
                    laudCurrentNum = DEFAULT_SIZE;
                }

                laudSuccessNum += this.laudFromVenuses(jsonObject, laudCurrentNum); //循环这个搭配图列表，进行点赞

                logger.info("============================================================");
                logger.info("已完成点赞，数量：" + laudSuccessNum);
                logger.info("============================================================");

                //满足条件则跳出循环。
                if (laudSuccessNum >= laudNum) {
                    logger.info("任务完成！已点赞：" + laudSuccessNum);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取搭配图列表
     *
     * @param start       开始
     * @param defaultSize 默认大小
     * @return json
     */
    private JSONObject getVenusList(int start, int defaultSize) {
        try {
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("start", "" + start));
            params.add(new BasicNameValuePair("size", "" + defaultSize));
            params.add(new BasicNameValuePair("tpid", "-1"));
            params.add(new BasicNameValuePair("_", "" + System.currentTimeMillis()));

            String execute = HttpClientUtil.execute(VENUS_LIST_URL, params);
            JSONObject jsonObject = new JSONObject(execute);

            logger.info("获取搭配图列表成功。【start：" + start + "】【size：" + defaultSize + "】");
            return jsonObject;

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取搭配图列表失败！");
        }

        return null;
    }


    /**
     * 循环这个搭配图列表，进行点赞
     *
     * @param jsonObject     搭配图列表
     * @param laudCurrentNum 本次需要点赞数量
     */
    private int laudFromVenuses(JSONObject jsonObject, int laudCurrentNum) {
        if (jsonObject == null) {
            return 0;
        }

        int laudSuccess = 0; //已成功点赞数量

        try {
            Integer status = (Integer) jsonObject.get("status");
            if (status == 200) {
                JSONObject attachment = jsonObject.getJSONObject("attachment");
                JSONArray venuses = attachment.getJSONArray("venuses");

                if (laudCurrentNum > venuses.length()) {
                    laudCurrentNum = venuses.length();
                }

                //去点赞
                for (int i = 0; i < venuses.length(); i++) {
                    JSONObject jsonObject1 = venuses.getJSONObject(i);
                    Integer venusId = (Integer) jsonObject1.get("id");
                    Boolean success = this.laudVenus(venusId);

                    if (success) {
                        //点赞成功，存储数据或发邮件
                        laudSuccess++;
                        if (laudSuccess >= laudCurrentNum) {
                            break;
                        }
                    }
                }
            } else {
                logger.error("点赞状态有误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return laudSuccess;
    }

    /**
     * 给搭配图点赞
     *
     * @param venusId 搭配图的id
     */
    private Boolean laudVenus(Integer venusId) {
        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("type", "260"));
            params.add(new BasicNameValuePair("tid", "" + venusId));
            params.add(new BasicNameValuePair("uid", "11806706"));
            params.add(new BasicNameValuePair("token", "w6TrMZ5dhQpGOmNn"));

            String execute = HttpClientUtil.execute(LAUD_VENUS_URL, params);
            JSONObject jsonObject = new JSONObject(execute);

            Integer status = (Integer) jsonObject.get("status");

            if (status == 200) {
                logger.info("点赞成功！搭配图的Id：" + venusId);
            } else {
                logger.error("点赞失败！" + jsonObject.toString() + "。搭配图的Id：" + venusId);
            }

            int sleepSeconds = new Random().nextInt(3) + 2;
            logger.info("自动点赞功能，沉睡：" + sleepSeconds + " 秒");
            TimeUnit.SECONDS.sleep(sleepSeconds);

            return status == 200;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
