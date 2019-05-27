package demo3DI;

import demo2IoC.hello.HelloApi;


/**
 * 静态工厂类，用于测试构造注入的静态工厂注入
 */
public class DependencyInjectByStaticFactory {
   public static HelloApi newInstance( String message, int index) {
       System.out.println("DependencyInjectByStaticFactory newInstance");
       return new HelloImpl3(message, index);
   }
}

