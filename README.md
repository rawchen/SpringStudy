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
    Dependency Injection
