package demo2IoC;

import demo2IoC.hello.HelloApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

public class BeanNameTest {
    @Test
    public void test1() {
        /**
         * 不指定id，只配置必须的全限定类名
         * <bean class="demo2IoC.hello.HelloImpl"/>
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo2IoC/BeanName1.xml");
        //根据类型获取bean
        HelloApi helloApi = beanFactory.getBean(HelloApi.class);
        helloApi.sayHello();
    }

    @Test
    public void test2() {
        /**
         * 指定id，必须在Ioc容器中唯一
         * <bean id="bean" class="demo2IoC.hello.HelloImpl"/>
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo2IoC/BeanName2.xml");
        //根据id获取bean
        HelloApi bean = beanFactory.getBean("bean", HelloApi.class);
        bean.sayHello();
    }

    @Test
    public void test3() {
        /**
         * 指定name，这样name就是“标识符”，必须在Ioc容器中唯一
         * <bean name="bean" class="demo2IoC.hello.HelloImpl"/>
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo2IoC/BeanName3.xml");
        //根据id获取bean
        HelloApi bean = beanFactory.getBean("bean", HelloApi.class);
        bean.sayHello();
    }

    @Test
    public void test4() {
        /**
         * 指定id和name，id就是标识符，而name就是别名，必须在Ioc容器中唯一
         * <bean id="bean1" name="alias1" class="demo2IoC.hello.HelloImpl"/>
         * <!-- 如果id和name一样，IoC容器能检测到，并消除冲突 -->
         * <bean id="bean3" name="bean3" class="demo2IoC.hello.HelloImpl"/>
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo2IoC/BeanName4.xml");

        //根据id获取bean
        HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
        bean1.sayHello();
        //根据别名获取bean
        HelloApi bean2 = beanFactory.getBean("alias1", HelloApi.class);
        bean2.sayHello();
        //根据id获取bean
        HelloApi bean3 = beanFactory.getBean("bean3", HelloApi.class);
        bean3.sayHello();

        String[] bean1s= beanFactory.getAliases("bean1");
        String[] bean3Alias = beanFactory.getAliases("bean3");
        //因此别名不能和id一样，如果一样则由IoC容器负责消除冲突
        System.out.println(bean1s.length + "|" + bean3Alias.length);
    }

    @Test
    public void test5() {
        /**
         * <!-- 五、指定多个name，多个name用","、";"、" "分割，第一个被用作id，
         *         其他的（alias1、alias2、alias3）是别名，所有标识符也必须在Ioc容器中唯一-->
         * <bean name="bean1;alias11,alias12;alias13 alias14" class="demo2IoC.hello.HelloImpl"/>
         * <!-- 当指定id时，name指定的标识符全部为别名 -->
         * <bean id="bean2" name="alias21;alias22" class="demo2IoC.hello.HelloImpl"/>
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo2IoC/BeanName5.xml");

        //1根据id获取bean
        HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
        bean1.sayHello();
        //2根据别名获取bean
        HelloApi alias11 = beanFactory.getBean("alias11", HelloApi.class);
        alias11.sayHello();
        //3验证确实是四个别名
        String[] bean1Alias = beanFactory.getAliases("bean1");
        System.out.println("=======namingbean5.xml bean1 别名========");
        for(String alias : bean1Alias) {
            System.out.println(alias);
        }
        System.out.println("bean1Alias.length:"+bean1Alias.length);
        //根据id获取bean
        HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
        bean2.sayHello();
        //2根据别名获取bean
        HelloApi alias21 = beanFactory.getBean("alias21", HelloApi.class);
        alias21.sayHello();
        //验证确实是两个别名
        String[] bean2Alias = beanFactory.getAliases("bean2");
        System.out.println("=======namingbean5.xml bean2 别名========");
        for(String alias : bean2Alias) {
            System.out.println(alias);
        }
        System.out.println("bean2Alias.length:"+bean2Alias.length);
    }

    @Test
    public void test6() {
        /**
         * <!--六、使用<alias>标签指定别名，别名也必须在IoC容器中唯一-->
         * <bean name="bean" class="demo2IoC.hello.HelloImpl"/>
         * <alias alias="alias1" name="bean"/>
         * <alias alias="alias2" name="bean"/>
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("demo2IoC/BeanName6.xml");

        //根据id获取bean
        HelloApi bean = beanFactory.getBean("bean", HelloApi.class);
        bean.sayHello();

        //根据别名获取bean
        HelloApi alias1 = beanFactory.getBean("alias1", HelloApi.class);
        alias1.sayHello();
        HelloApi alias2 = beanFactory.getBean("alias2", HelloApi.class);
        alias2.sayHello();

        String[] beanAlias = beanFactory.getAliases("bean");
        System.out.println("=======namingbean6.xml bean 别名========");
        for(String alias : beanAlias) {
            System.out.println(alias);
        }
        System.out.println("=======namingbean6.xml bean 别名========");
        System.out.println("beanAlias.length:"+ beanAlias.length);
    }

}
