# Spring代码示例：

Modules：demoSpring3

Spring-4.3.18.RELEASE

JUnit5.3



## IoC代码示例：

|-demoSpring3/src/demo2IoC

|-demoSpring3/resource/demo2IoC

### hello world

|-demoSpring3/src/demo2IoC/hello/*.java

|-demoSpring3/resource/demo2IoC/hello.xml

### Instantiation ContainerTest 

实例化容器：

|-demoSpring3/src/demo2IoC/InstantiatingContainerTest.java

|-demoSpring3/resource/demo2IoC/classpath.xml

BeanFactory对象的实例化、

ApplicationContext对象的实例化

getBean方法获取实例化对象

### Name Bean

Bean的命名:

|-demoSpring3/src/demo2IoC/BeanNameTest.java

|-demoSpring3/resource/demo2IoC/BeanName[1-6].xml

bean的id、name、alias标识符及class定义类

### Instantiating Bean

实例化Bean：（主要示例代码）

|-demoSpring3/src/demo2IoC/InstantiatingBeanTest.java

|-demoSpring3/resource/demo2IoC/InstantiatingBean.xml

#### 构造器实例化：

|-demoSpring3/src/demo2IoC/HelloImpl2.java

<constructor-arg>属性标签用来指定构造器（非必须）及构造器参数，其中index表示位置，value表示常量值。若无则标识使用空构造器实例化，且class属性指定的类必须有空构造器。

ref：待示例。

#### 静态工厂实例化

|-demoSpring3/src/demo2IoC/HelloApiStaticFactory.java

<factory-method>属性标签来指定实例化Bean的方法（必须，且class属性必须指定），同时也允许使用<constructor-arg>属性标签来指定方法参数（非必须）

#### 工厂方法实例化

|-demoSpring3/src/demo2IoC/HelloApiInstanceFactory.java

首先定义实例化工厂Bean，用于定义实例化工厂Bean及其对应的类的定义（必须）

之后定义工厂方法Bean，<factory-bean>属性标签来指定工厂Bean（必须，且class属性不能指定），<factory-method>属性标签来指定实例化Bean的方法（必须），同时也允许使用<constructor-arg>属性标签来指定方法参数（非必须）



## DI代码示例：

|-demoSpring3/src/demo3DI/

|-demoSpring3/resource/demo3DI/

### Dependency Inject

依赖注入：

|-demoSpring3/src/demo3DI/DependencyInjectTest.java



#### Constructor Dependency Inject

构造器依赖注入：

|-demoSpring3/src/demo3DI/HelloImpl3.java

|-demoSpring3/resource/demo3DI/DependencyInjectByConstructor.xml

使用<constructor-arg>属性标签根据参数索引（index、value）、根据参数类型（type、value）、根据参数名称（name、value），进行指定。

#### StaticFactory Dependency Inject

静态工厂注入：

|-demoSpring3/src/demo3DI/DependencyInjectByStaticFactory.java

|-demoSpring3/resource/demo3DI/DependencyInjectByStaticFactory.xml

在静态工厂实例化的基础上，使用<constructor-arg>属性标签，根据参数索引（index、value）、根据参数类型（type、value）、根据参数名称（name、value），进行指定。

#### InstanceFactory Dependency Inject

工厂方法注入：

|-demoSpring3/src/demo3DI/DependencyInjectByInstanceFactory.java

|-demoSpring3/resource/demo3DI/DependencyInjectByInstanceFactory.xml

在工厂方法实例化的基础上，使用<constructor-arg>属性标签根据参数索引（index、value）、根据参数类型（type、value）、根据参数名称（name、value），进行指定。

#### Setter Dependency Inject

setter注入：

|-demoSpring3/src/demo3DI/HelloImpl4.java

|-demoSpring3/resource/demo3DI/DependencyInjectSetter.xml

使用<property>属性标签，根据参数索引（index、value）、根据参数类型（type、value）、根据参数名称（name、value），进行指定。setter方法名要符合“Java Bean”命名规范

#### Boolean Dependency Inject

注入常量，Boolean容错注入

|-demoSpring3/src/demo3DI/BeanBooleanTest.java

|-demoSpring3/resource/demo3DI/DependencyInjectBoolean.xml

仍然使用<property>属性标签，除“true/false”标准的Java值进行注入以外，还能使用“yes/no”、“on/off”、“1/0”来代表“真/假”。

#### BeanID Dependency Inject

注入BeanID

|-demoSpring3/src/demo3DI/Bean/BeanIdRefTest.java

|-demoSpring3/resource/demo3DI/BeanIdRefInject.xml

注入的Bean的ID是一个java.lang.String类型，即字符串类型，因此注入的同样是常量，只是具有校验功能。

<idref bean="……"/>将在容器初始化时校验注入的ID对于的Bean是否存在，如果不存在将抛出异常。



注入集合、数组、字典等





引用其他Bean