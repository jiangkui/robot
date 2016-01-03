package com.ljkdream.controller;

import com.ljkdream.entity.UnifiedResponse;
import com.ljkdream.entity.UnifiedResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册任务的测试
 * Created by LJK on 2015/10/12.
 */
@Controller
public class RegisterSupplerController {
    private final static Map<String, String> ZHUCE_CACHE = new HashMap<>();
    private final static Map<String, String> DENGJI_CACHE = new HashMap<>();

    @ResponseBody
    @RequestMapping("zhuce")
    public String zhuce(
            @RequestParam(required = true) String key,
            @RequestParam(required = true) String responseType
        ) {

        boolean exist = false;

        if (StringUtils.isNotBlank(key)) {
            exist = ZHUCE_CACHE.containsKey(key);
        }

        if ("json".equals(responseType)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("register", exist);
            return jsonObject.toString();
        } else {
            return exist + "";
        }
    }

    @ResponseBody
    @RequestMapping("dengji")
    public String dengji(
            @RequestParam(required = true) String key,
            @RequestParam(required = true) String responseType
        ) {

        boolean exist = false;

        if (StringUtils.isNotBlank(key)) {
            exist = DENGJI_CACHE.containsKey(key);
            DENGJI_CACHE.put(key, key);
        }

        if ("json".equals(responseType)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("dengji", exist);
            return jsonObject.toString();
        } else {
            return exist+"";
        }
    }

    @ResponseBody
    @RequestMapping("util")
    public Object util(
            @RequestParam(required = true) String key,
            @RequestParam(required = true) Integer operation, //1增加 2删除
            @RequestParam(required = true) Integer type  //1 zhuce  2dengji
        ) {

        if (operation == 1) {
            if (type == 1) {
                ZHUCE_CACHE.put(key, key);
            } else {
                DENGJI_CACHE.put(key, key);
            }
        } else {
            if (type == 1) {
                ZHUCE_CACHE.remove(key);
            } else {
                DENGJI_CACHE.remove(key);
            }
        }

        return new UnifiedResponse(UnifiedResponseCode.RC_SUCC, "操作成功！");
    }

}
