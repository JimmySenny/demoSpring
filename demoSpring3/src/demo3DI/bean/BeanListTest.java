package demo3DI.bean;

import java.util.List;

/**
 * 注入List类型的测试Bean类
 */
public class BeanListTest {
    private List<String> values;
    public List<String> getValues() {
        return values;
    }
    public void setValues(List<String> values) {
        this.values = values;
    }

}
