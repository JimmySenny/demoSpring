package demo3DI;

import demo2IoC.hello.HelloApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 构造注入示例
 */
public class DependencyInjectTest {
    @Test
    public void testConstructorDependencyInjectTest() {
        BeanFactory beanFactory =  new ClassPathXmlApplicationContext("demo3DI/constructorDependencyInject.xml");
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
}
