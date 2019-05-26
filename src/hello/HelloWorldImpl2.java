package hello;

public class HelloWorldImpl2 implements HelloWorldApi {
    private String message;
    public HelloWorldImpl2() {
        this.message = "HelloImpl2!";
    }
    public HelloWorldImpl2(String message) {
        this.message = message;
    }
    @Override
    public void sayHello() {
        System.out.println(message);
    }
}

