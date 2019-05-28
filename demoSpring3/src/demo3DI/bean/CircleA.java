package demo3DI.bean;

/**
 * 测试循环依赖
 */
public class CircleA {
    private CircleB circleB;
    public CircleA() {
    }
    public CircleA(CircleB circleB) {
        this.circleB = circleB;
    }
    public void setCircleB(CircleB circleB)
    {
        this.circleB = circleB;
    }
    public void a() {
        circleB.b();
    }
}
