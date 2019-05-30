package demo3DI.bean;

import java.io.IOException;

/**
 * depends-on 测试类
 */
public class BeanDependent {
    BeanResource beanresource;

    public void write(String ss) throws IOException {
        System.out.println("DependentBean:=========写资源");
        beanresource.getFos().write(ss.getBytes());
    }

    //初始化方法
    public void init() throws IOException {
        System.out.println("DependentBean:=========初始化");
    }
    //销毁方法
    public void destroy() throws IOException {
        System.out.println("DependentBean:=========销毁");
        //在销毁之前需要往文件中写销毁内容
        beanresource.getFos().write("DependentBean:=========销毁=====".getBytes());
    }

    public void setBeanresource(BeanResource beanresource) {
        this.beanresource = beanresource;
    }
}
