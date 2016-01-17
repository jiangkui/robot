package com.ljkdream.study.jconsole;

import com.ljkdream.core.entity.UnifiedResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Java 可视化工具使用测试
 * Created by ljk on 16-1-17.
 */
@Controller
public class OOMTest {

    private Logger logger = LoggerFactory.getLogger(OOMTest.class);

    /**
     * file heap test
     * @return json
     * @throws InterruptedException
     */
    @ResponseBody
    @RequestMapping("fillHeap")
    public UnifiedResponse fillHeap() throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            TimeUnit.MILLISECONDS.sleep(50);
            list.add(new OOMObject());
            logger.info("fill heap..." + i);
        }
        System.gc();
        logger.info("内存回收完毕！");
        return new UnifiedResponse();
    }

}

class OOMObject {
    public byte[] placeholder = new byte[64 * 1024];
}
