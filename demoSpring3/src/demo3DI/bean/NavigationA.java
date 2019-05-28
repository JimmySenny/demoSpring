package demo3DI.bean;


/**
 * 测试对象图导航注入
 * 前端类，通过对它的导航进行注入值
 */
public class NavigationA {
    private NavigationB navigationB;

    public NavigationB getNavigationB() {
        return navigationB;
    }

    public void setNavigationB(NavigationB navigationB) {
        this.navigationB = navigationB;
    }
}
