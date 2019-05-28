package demo3DI;

import demo2IoC.hello.HelloApi;
import demo3DI.bean.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.Map;

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

    /**
     * 常量注入 Boolean
     */
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

    /**
     * 注入BeanID
     */
    @Test
    public void testIdRefInject() {
        BeanFactory   beanFactory = new ClassPathXmlApplicationContext("demo3DI/BeanIdRefInject.xml");
        BeanIdRefTest bean1       = beanFactory.getBean("idrefBean1", BeanIdRefTest.class);
        System.out.println(bean1.getId());
        /*
        BeanIdRefTest bean2 = beanFactory.getBean("idrefBean2", BeanIdRefTest.class);
        System.out.println(bean2.getId());
         */
        System.out.println("---------------");

        ApplicationContext context = new ClassPathXmlApplicationContext("demo3DI/BeanIdRefInject.xml");
        System.out.println(context.getBean("idrefBean3",BeanIdRefTest.class).getId());
    }

    /**
     * 注入集合List
     */
    @Test
    public void testListInject() {
        BeanFactory  beanFactory = new ClassPathXmlApplicationContext("demo3DI/BeanlistInject.xml");
        BeanListTest listBean    = beanFactory.getBean("listBean", BeanListTest.class);
        System.out.println(listBean.getValues().size());

        Iterator<String> iter = listBean.getValues().iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    /**
     * 注入字典Map
     */
    @Test
    public void testMapInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo3DI/BeanMapInject.xml");
        BeanMapTest mapBean     = beanFactory.getBean("mapBean", BeanMapTest.class);
        System.out.println(mapBean.getMap().size());

        Iterator<Map.Entry<String,String>> iter = mapBean.getMap().entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String,String> entry = null;
            entry = iter.next();
            System.out.format("Key[%s]Value[%s]\n",entry.getKey(),entry.getValue());
        }
    }

    /**
     * 引用其他Bean
     */
    @Test
    public void testBeanInject() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo3DI/BeanInject.xml");
        //通过构造器方式注入
        HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
        bean1.sayHello();
        //通过setter方式注入
        HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
        bean2.sayHello();
    }

    /**
     * 注入其他Bean类型值 通过inner bean
     */
    @Test
    public void testInnerBeanInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("demo3DI/BeanInnerInject.xml");
        HelloApi bean = context.getBean("bean", HelloApi.class);
        bean.sayHello();
    }

    /**
     * 对象图导航
     */
    @Test
    public void testNavigationBeanInject() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("demo3DI/BeanNavigationInject.xml");
        NavigationA navigationA = context.getBean("a", NavigationA.class);
        navigationA.getNavigationB().getNavigationC().sayNavigation();
        navigationA.getNavigationB().getList().get(0).sayNavigation();
        navigationA.getNavigationB().getMap().get("key").sayNavigation();
        navigationA.getNavigationB().getArray()[0].sayNavigation();
        ((NavigationC)navigationA.getNavigationB().getProperties().get("1")).sayNavigation();
    }

    @Test
    public void testPNamespaceBeanInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("demo3DI/BeanIdRefInjectBypName.xml");
        System.out.println("value:"+context.getBean("idrefBean1",BeanIdRefTest.class).getId());
        System.out.println("test:"+context.getBean("idrefBean2", BeanIdRefTest.class).getId());

    }
}
