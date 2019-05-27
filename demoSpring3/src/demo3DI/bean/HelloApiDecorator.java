package demo3DI.bean;

import demo2IoC.hello.HelloApi;

/**
 * 引用其他Bean的测试类
 */
public class HelloApiDecorator implements HelloApi {
    private HelloApi helloapi;

    public HelloApiDecorator() {
        System.out.println("HelloApiDecorator() constructor:"+this.toString());
    }

    public HelloApiDecorator(HelloApi helloapi) {
        System.out.println("HelloApiDecorator(HelloApi) constructor:"+this.toString());
        this.helloapi = helloapi;
    }

    public void setHelloapi(HelloApi helloapi) {
        System.out.println("setHelloApi(HelloApi):"+helloapi.toString());
        this.helloapi = helloapi;
    }

    @Override
    public void sayHello() {
        System.out.println("HelloApiDecorator.sayHello 装饰前");
        System.out.println(this.toString());
        this.helloapi.sayHello();
        System.out.println("HelloApiDecorator.sayHello 装饰后");
    }
}
