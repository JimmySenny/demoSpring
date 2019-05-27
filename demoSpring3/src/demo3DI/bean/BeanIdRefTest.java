package demo3DI.bean;

/**
 * 用于BeanID测试的Bean类
 */
public class BeanIdRefTest {
    private String id;

    /*
    public BeanIdRefTest(String id) {
        System.out.println("BeanIdRefTest()"+id);
        this.id = id;
    }
     */

    public String getId() {
        System.out.println("BeanIdRefTest getId:"+this.id);
        return id;
    }
    public void setId(String id) {
        System.out.println("BeanIdRefTest setId:"+id);
        this.id = id;
    }
}
