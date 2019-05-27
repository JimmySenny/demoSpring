package demo3DI;

/**
 * spring类型转换对boolean的容错测试类
 */
public class BeanBooleanTest {
    private boolean success;

    public void setSuccess( boolean success ) {
        this.success = success;
    }

    public boolean isSuccess(){
        return this.success;
    }
}
