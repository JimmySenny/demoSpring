package demo2IoC;

import demo2IoC.hello.HelloApi;

/**
 * 实例工厂方法（非静态工厂方法），用于测试Bean通过实例工厂方法实例化
 */
public class HelloApiInstanceFactory {
    public HelloApi newInstance(String message) {
        HelloApi helloApi = new HelloImpl2(message);
        System.out.println("HelloApiInstanceFactory newInstance"+helloApi.toString());
        return helloApi;
    }
}
