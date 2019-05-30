package demo3DI;

import demo2IoC.hello.HelloApi;
import demo3DI.bean.BeanList;
import demo3DI.bean.BeanListTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import java.io.IOException;

public class AutoWriteBeanTest {
    @Test
    public void testAutowireByName() throws IOException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("demo3DI/AutoWriteByName.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }

    @Test
    public void testAutowireByType1() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo3DI/AutoWriteByType.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }

    @Test
    public void testAutowireByType2_1() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo3DI/AutoWriteByType2-1.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }

    @Test
    public void testAutowireByType2_2() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo3DI/AutoWriteByType2-2.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }
    @Test
    public void testAutowireByType2_3() throws IOException {
        ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("demo3DI/AutoWriteByType2-2.xml");
        BeanList                       listBean = context.getBean("listBean", BeanList.class);
        //对于集合接口根据类型注入将自动查找所有匹配的注入
        System.out.println(listBean.getList1().size());
        //对于集合具体类型将根据具体类型进行注入，而不是选择所有泛型类型信息匹配的Bean
        System.out.println(listBean.getList2().size());
    }
}
