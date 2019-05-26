package demo2IoC;

import demo2IoC.hello.HelloApi;

/**
 * HelloApi的静态工厂 用于静态工厂方法实例化Bean测试
 */
public class HelloApiStaticFactory {
    //静态工厂方法
    public static HelloApi newInstance(String message) {
        //返回需要的Bean实例
        HelloApi helloApi = new HelloImpl2(message);
        System.out.println("HelloApiStaticFactory newInstance" + helloApi.toString() );
        return helloApi;
    }
}
