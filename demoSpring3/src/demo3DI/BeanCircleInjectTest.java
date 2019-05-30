package demo3DI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanCircleInjectTest {

    @Test//(expected = BeanCurrentlyInCreationException.class)
    public void testCircleByConstructor() throws Throwable{
        try {
            new ClassPathXmlApplicationContext("demo3DI/BeanCircleInjectByConstructor.xml");
        }
        catch (Exception e) {
            //因为要在创建circle3时抛出；
            System.out.println("catch");
            e.printStackTrace();
            Throwable e1 = e.getCause().getCause().getCause();
            e1.printStackTrace();
            //throw e1;
        }finally {
            System.out.println("finally");
        }

    }

    @Test//(expected = BeanCurrentlyInCreationException.class)
    public void testCircleBySetterAndPrototype () throws Throwable {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                    "demo3DI/BeanCircleInjectBySetter.xml");
            System.out.println(ctx.getBean("circleA"));
        }
        catch (Exception e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

    @Test//(expected = BeanCurrentlyInCreationException.class)
    public void circleBySetterAndPrototypeTest() throws Throwable {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("demo3DI/BeanCircleInjectBySingleton.xml");
            System.out.println(ctx.getBean("circleA"));
        }
        catch (Exception e) {
            //因为要在创建circle3时抛出；
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

}
