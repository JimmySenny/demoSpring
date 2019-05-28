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

}
