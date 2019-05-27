package demo3DI;

import demo2IoC.hello.HelloApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入测试
 */
public class DependencyInjectTest {
    /**
     * 构造注入示例
     */
    @Test
    public void testConstructorDependencyInjectTest() {
        BeanFactory beanFactory =  new ClassPathXmlApplicationContext( "demo3DI/DependencyInjectByConstructor.xml" );
        //获取根据参数索引依赖注入的Bean
        HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();
        //获取根据参数类型依赖注入的Bean
        HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
        byType.sayHello();
        //获取根据参数名字依赖注入的Bean
        HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
        byName.sayHello();
    }
    @Test
    public void testStaticFactoryDependencyInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext( "demo3DI/DependencyInjectByStaticFactory.xml" );
        //获取根据参数索引依赖注入的Bean
        HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();

        //获取根据参数类型依赖注入的Bean
        HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
        byType.sayHello();

        //获取根据参数名字依赖注入的Bean
        HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
        byName.sayHello();
    }
    @Test
    public void testInstanceFactoryDependencyInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo3DI/DependencyInjectByInstanceFactory.xml");
        //获取根据参数索引依赖注入的Bean
        HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();
        //获取根据参数类型依赖注入的Bean
        HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
        byType.sayHello();
        //获取根据参数名字依赖注入的Bean
        HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
        byName.sayHello();
    }

    /**
     * setter注入
     */
    @Test
    public void testSetterDependencyInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo3DI/DependencyInjectSetter.xml");
        HelloApi bean = beanFactory.getBean("bean", HelloApi.class);
        bean.sayHello();
    }

    @Test
    public void testBooleanInject() {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext( "demo3DI/DependencyInjectBoolean.xml" );

        BeanBooleanTest bean1 = beanFactory.getBean("bean1", BeanBooleanTest.class);
        System.out.println(bean1.isSuccess());

        BeanBooleanTest bean2 = beanFactory.getBean("bean2", BeanBooleanTest.class);
        System.out.println(bean2.isSuccess());

        BeanBooleanTest bean3 = beanFactory.getBean("bean3", BeanBooleanTest.class);
        System.out.println(bean3.isSuccess());

        BeanBooleanTest bean4 = beanFactory.getBean("bean4", BeanBooleanTest.class);
        System.out.println(bean4.isSuccess());
    }

}
