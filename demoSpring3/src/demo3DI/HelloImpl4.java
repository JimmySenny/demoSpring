package demo3DI;

import demo2IoC.hello.HelloApi;

public class HelloImpl4 implements HelloApi {
    private String message;
    private int index;

    public void setMessage( String message ) {
        this.message = message;
        System.out.println("setMessage" );
    }
    public void setIndex( int index ) {
        this.index = index;
        System.out.println("setIndex" );
    }
    @Override
    public void sayHello( ) {
        System.out.println("this.message:" + message);
        System.out.println("this.index:"+index);
    }
}
