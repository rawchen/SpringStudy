# SpringStudy

学习Spring框架的学习记录

## 03spring

把对象的创建交给spring来管理

 1. 获取核心容器对象

    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

2. 根据id获取Bean对象

   IAccountService as = (IAccountService)ac.getBean("accountService");

   IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);

   

   --------------------BeanFactory-----------------------

   Resource resource = new ClassPathResource("bean.xml");

   BeanFactory beanFactory = new XmlBeanFactory(resource);

   IAccountService as = (IAccountService)beanFactory.getBean("accountService");

ApplicationContext的三个常用实现类

* ClassPathXmlApplicationContext  可以加载类路径下的配置文件

* FileSystemXmlApplicationContext  可以加载磁盘任意路径下的配置文件(必须有访问权限)

* AnnotationConfigApplicationContext  它是用于读取注解创建容器的

核心容器的两个接口引发的出的问题

* ApplicationContext       单例对象适用      采用此接口

  它在构建核心容器时，创建对象采取的策略是立即加载的方式，一读取文件马上就创建配置文件中配置的对象。

* BeanFactory              多例对象适用

  它在构建核心容器时，创建对象采取的策略是延迟加载的方式，什么时候根据id获取对象了，什么时候才真正创建了对象。
         

## 04bean

### spring对bean的管理细节
1. 创建bean的三种方式
    * 第一种方式：适用默认构造函数创建。
        - 在spring的配置文件中使用bean标签，配以id和class属性之后，且没有其他属性和标签时。
        - 采用的就是默认构造函数创建bean对象，此时如果类中没有默认构造函数，则对象无法创建。
        ```Java
        <bean id="accountService" class="com.yoyling.service.impl.AccountServiceImpl"></bean>
        ```
    * 第二种方式：使用普通工厂中的方法创建对象(使用某个类中的方法创建对象，并存入spring容器)
        ```Java
        <bean id="instanceFactory" class="com.yoyling.factory.InstanceFactory"></bean>
        <bean id="accountService" factory-bean="instanceFactory" factory-method="getAccountService"></bean>
        ```
    * 第三种方式：使用工厂中的静态方法创建对象（使用某个类中的静态方法创建方法并存入spring容器）
        ```Java
        <bean id="accountService" class="com.yoyling.factory.StaticFactory"></bean>
        ```
2. bean对象作用范围
    * bean标签的scope属性：
        - 作用：用于指定bean的作用范围
        - 取值：常用单例和多例
            * singleton 单例的（默认值）
            * prototype 多例的
            * request 作用于web应用的请求范围
            * session 作用于web应用的绘画范围
            * global-session 作用于集群环境的会话范围（全局会话范围），当不是集群环境时，就是session
                ```Java
                <bean id="accountService" class="com.yoyling.service.impl.AccountServiceImpl" scope="prototype"></bean>
                ```
3. bean对象的生命周期
    * 单例对象-和容器相同（立即）
        - 出生：当容器创建时对象出生
        - 活着：只要容器还在，对象一直活
        - 死亡：容器销毁，对象销毁
    * 多例对象（延迟）
        - 出生：当我们使用对象时，spring框架为我们创建
        - 活着：对象只要在使用过程中就一直活着
        - 死亡：当对象长时间不用，且没有别的对象引用时，由Java垃圾回收器回收
## 05DI
### 依赖注入：
    - Dependency Injection
### IOC的作用：
    - 降级程序间的耦合（依赖关系）
### 依赖关系的管理：
    - 以后都交给了spring来维护
在当前类中需要用到其它类的对象，由spring为我们提供，我们只需要在配置文件中说明
### 依赖关系的维护：
    - 就称之为依赖注入。
依赖注入：
    - 能注入的数据有三类：
        - 基本类型和string
        - 其他bean类型（在配置文件中或者注解配置过的bean）
        - 复杂类型/集合类型
    - 注入的方式有三种：
        - 第一种：使用构造函数提供
        - 第二种：使用set方法
        - 第三种：使用注解提供
### 构造函数注入：
    - 使用constructor-arg
    - 便签出现的位置：bean标签的内部
    - 标签中的属性：
        - type：用于指定要注入的数据的数据类型，也是构造函数中某些参数的类型
        - index：用指定要注入的数据给构造函数中的指定索引位置的参数赋值，索引从0开始
        - name：用于指定给构造函数中指定名称的参数赋值  （常用的）
        - ==================以上三个用于指定给构造函数中哪个参数赋值=============
        - value：用于提供基本类型和String类型的数据
        - ref：用于指定其它的bean类型数据，它指的就是在spring的IOC核心容器中出现过的bean对象 
    - 优势：
        - 在获取bean对象时，注入数据是必须的操作，否则对象无法创建成功。
    - 弊端：
        - 改变了bean对象的实例化方式，使我们在创建对象时，如果用不到这些数据也必须提供。
        ```Java
        <bean id="accountService" class="com.yoyling.service.impl.AccountServiceImpl">
            <constructor-arg name="name" value="泰雷瑟"></constructor-arg>
            <constructor-arg name="age" value="18"></constructor-arg>
            <constructor-arg name="birthday" ref="now"></constructor-arg>
        </bean>

        <!-- 配置一个日期对象 -->
        <bean id="now" class="java.util.Date"></bean>
        ```
### set方法注入（更常用）
    - 涉及的标签：property
    - 出现的位置：bean标签的内部
    - 标签的属性：
        - name：用于指定注入时所调用的set名称
        - value：用于提供基本类型和String类型的数据
        - ref：用于指定其它的bean类型数据，它指的就是在spring的IOC核心容器中出现过的bean对象
    - 优势：
        - 创建对象时，没有明确限制，可直接使用默认构造函数
    - 弊端：
        - 如果有某个成员必须有值，则获取对象时有可能set方法没有执行。
        ```Java
        <bean id="accountService2" class="com.yoyling.service.impl.AccountServiceImpl2">
            <property name="name" value="test"></property>
            <property name="age" value="21"></property>
            <property name="birthday" ref="now"></property>
        </bean>
        ```
### 复杂类型的注入/集合类型的注入
    - 用于给List结构集合注入的标签有：
        - List Array Set
    - 用于给Map结构集合注入的标签有：
        - Map Props
    - 结构相同标签可以互换
    ````Java
    <bean id="accountService3" class="com.yoyling.service.impl.AccountServiceImpl3">
        <property name="myStrs">
            <array>
                <value>AAA</value>
                <value>BBB</value>
                <value>CCC</value>
            </array>
        </property>

        <property name="myList">
            <list>
                <value>AAAList</value>
                <value>BBBList</value>
                <value>CCCList</value>
            </list>
        </property>

        <property name="mySet">
            <set>
                <value>AAASet</value>
                <value>BBBSet</value>
                <value>CCCSet</value>
            </set>
        </property>

        <property name="myMap">
            <map>
                <entry key="a" value="AAAMap"></entry>
                <entry key="b">
                    <value>BBBMap</value>
                </entry>
            </map>
        </property>

        <property name="myProps">
            <props>
                <prop key="textC">CCCProps</prop>
                <prop key="textD">DDDProps</prop>
            </props>
        </property>
    </bean>
    ```
