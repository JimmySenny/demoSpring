package demo3DI;

import demo2IoC.hello.HelloApi;

/**
 * 实例工厂方法类，用于测试构造注入的实例工厂注入
 */
public class DependencyInjectByInstanceFactory {
    public HelloApi newInstance( String message, int index) {
        System.out.println( "DependencyInjectByInstanceFactory newInstance" );
        return new HelloImpl3(message, index);
    }
}
