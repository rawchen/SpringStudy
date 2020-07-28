package com.yoyling.test;

import com.yoyling.config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试queryRunner是否单例
 */
public class QueryRunnerTest {
    @Test
    public void testQueryRunner() {
        //1.获取容易
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取queryRunner对象
        QueryRunner queryRunner = ac.getBean("queryRunner",QueryRunner.class);
        QueryRunner queryRunner1 = ac.getBean("queryRunner",QueryRunner.class);
        System.out.println(queryRunner);
        System.out.println(queryRunner1);
    }
}
