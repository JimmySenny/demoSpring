package demo2IoC;

import demo2IoC.hello.HelloApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 实例化Bean测试
 */
public class InstantiatingBeanTest {

    @Test
    public void testInstantiatingBeanByConstructor() {
        /**
         * 使用构造器
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo2IoC/InstantiatingBean.xml");
        HelloApi    bean1       = beanFactory.getBean("bean1", HelloApi.class);
        bean1.sayHello();
        HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
        System.out.println("Test bean1:"+bean1.toString());
        System.out.println("Test bean2:"+bean2.toString());
        bean2.sayHello();
    }

    @Test
    public void testInstantiatingBeanByStaticFactory() {
        /**
         * 使用静态工厂方法
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo2IoC/InstantiatingBean.xml");
        HelloApi bean3 = beanFactory.getBean("bean3", HelloApi.class);
        System.out.println("Test bean3:"+bean3.toString());
        bean3.sayHello();
    }

    @Test
    public void testInstantiatingBeanByInstanceFactory() {
        /**
         * 使用实例工厂方法
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo2IoC/InstantiatingBean.xml");
        HelloApi bean4 = beanFactory.getBean("bean4", HelloApi.class);
        System.out.println("Test bean4:"+bean4.toString());
        bean4.sayHello();
    }

}
