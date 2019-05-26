package demo3DI;

import demo2IoC.hello.HelloApi;

/**
 * 构造器注入的测试类
 */
public class HelloImpl3 implements HelloApi {
    private String message;
    private int index;

    //@java.beans.ConstructorProperties({"message", "index"})
    public HelloImpl3(String message, int index) {
        this.message = message;
        this.index = index;
        System.out.println("constructor:"+this.index);
    }
    @Override
    public void sayHello() {
        System.out.println("this.message:" + message);
        System.out.println("this.index:"+index);
    }
}
