package com.yoyling.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 该类为一个配置类，它的作用和bean.xml是一样的
 * spring中的新注解
 * Configuaration
 *     作用：指定当前类为一个配置类
 * ComponentScan
 *     作用：用于通过注解指定spring在创建容器时要扫描的包
 *     属性：
 *         value：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包。
 *             我们使用此注解等同于在xml中配置了
 *             <context:component-scan base-package="com.yoyling"></context:component-scan>
 * Bean
 *     作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *     属性：
 *         name:用于指定bean的id，不写时默认值是当前方法的名称
 *     细节：
 *         当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
 *         查找方式和Autowired注解的作用是一样的
 */
@Configuration
@ComponentScan("com.yoyling")
public class SpringConfiguration {

    /**
     * 用于创建一个QueryRunner对象
     * @param dataSource
     * @return
     */
    @Scope("prototype")
    @Bean(name = "queryRunner")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/springtest");
            ds.setUser("root");
            ds.setPassword("root");
            return ds;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            return null;
        }

    }
}
