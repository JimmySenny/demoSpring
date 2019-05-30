package demo3DI;

import demo3DI.bean.BeanDependent;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MoreDependencyInjectTest {
    @Test
    public void testDependOn() throws IOException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("demo3DI/BeanDependent.xml");
        //一点要注册销毁回调，否则我们定义的销毁方法不执行
        context.registerShutdownHook();
        BeanDependent dependentBean = context.getBean("BeanDependent", BeanDependent.class);
        dependentBean.write("aaa");
    }
}
