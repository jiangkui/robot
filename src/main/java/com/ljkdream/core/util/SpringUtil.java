package com.ljkdream.core.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 工具类，获取容器中的service
 * Created by LJK on 2015/6/8.
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    public static <T> T getBean(String beanName) {
        if (StringUtils.isEmpty(beanName)) {
            return null;
        }
        char c = beanName.charAt(0);
        char c1 = beanName.charAt(1);
        if (c >= 'A' && c <= 'Z' && !(c1 >= 'A' && c1 <= 'Z')) {
            beanName = String.valueOf((char) (c + 32)) + beanName.substring(1);
        }
        T t = null;
        try {
            t = (T) context.getBean(beanName);
        } catch (BeansException e) {
            t = (T) context.getBean(beanName + "Impl");
        }
        return t;
    }

    public static <T> T getBean(Class clazz) {
        return getBean(clazz.getSimpleName());
    }

    @Override
    public void setApplicationContext(ApplicationContext context)
            throws BeansException {
        this.context = context;
    }
}
