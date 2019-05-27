package demo3DI.bean;

import java.util.Map;

/**
 * 注入Map的测试Bean类
 */
public class BeanMapTest {
    private Map<String ,String> map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
