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
        -在spring的配置文件中使用bean标签，配以id和class属性之后，且没有其他属性和标签时。
        -采用的就是默认构造函数创建bean对象，此时如果类中没有默认构造函数，则对象无法创建。
2. bean对象作用范围
3. bean对象的生命周期
