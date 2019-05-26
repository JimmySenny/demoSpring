package hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
    public static void main(String[] args) {
        /*
        //1、读取配置文件实例化一个IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
        HelloApi hello = context.getBean("HelloImpl", HelloApi.class);
        //3、执行业务逻辑
        hello.sayHello();
         */

        BeanFactory bf = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloApi helloapi = bf.getBean(hello.HelloApi.class);
        helloapi.sayHello();
    }
}
