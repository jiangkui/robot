package com.ljkdream.test;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理
 * Created by LJK on 2015/10/20.
 */
public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        /*
            通过调用静态方法 Proxy.newProxyInstance() 可以创建动态代理，这个方法需要得到一个类加载器，
          一个你希望该代理实现的接口列表，以及 InvocationHandler 接口的一个实现。动态代理可以将所有调用
          重定向到调用处理器，因此通常会向调用处理器的构造器传递给一个 “实际” 对象的引用，从而使得调用处理器
          在执行其中介任务时，可以将请求转发

        */
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}


class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("****  proxy:" + proxy.getClass() + ", method:" + method + ", args:" + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println("  " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}