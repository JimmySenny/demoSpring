package demo2IoC.hello;

public class HelloImpl implements HelloApi {
    @Override
    public void sayHello() {
        System.out.println("Hello World!:"+this.toString());
    }
}
