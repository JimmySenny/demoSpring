package demo2IoC;

import demo2IoC.hello.HelloApi;

/**
 * 具有构造的类，用于Bean使用构造实例化测试
 */
public class HelloImpl2 implements HelloApi{
    private String message;

    public HelloImpl2() {
    }

    public HelloImpl2(String message) {
        this.message = message;
    }

    @Override
    public void sayHello() {
        System.out.println("hello "+this.message);
    }
}
