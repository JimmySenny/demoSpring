package demo3DI.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 测试对象图导航注入
 * 包含对象和列表、Properties、数组字典数据类型导航，而且这些复合数据类型保存的条目都是对象，
 * 正好练习一下如何往复合数据类型中注入对象依赖
 */
public class NavigationB {
    private NavigationC              navigationC;
    private List<NavigationC>        list;
    private Properties               properties;
    private NavigationC[]            array = new NavigationC[1];
    private Map<String, NavigationC> map;

    public NavigationC getNavigationC() {
        return navigationC;
    }

    public void setNavigationC(NavigationC navigationC) {
        this.navigationC = navigationC;
    }

    public List<NavigationC> getList() {
        return list;
    }

    public void setList(List<NavigationC> list) {
        this.list = list;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public NavigationC[] getArray() {
        return array;
    }

    public void setArray(NavigationC[] array) {
        this.array = array;
    }

    public Map<String, NavigationC> getMap() {
        return map;
    }

    public void setMap(Map<String, NavigationC> map) {
        this.map = map;
    }
}
