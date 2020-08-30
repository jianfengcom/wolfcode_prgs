package com.example.crud.test;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class ConfigurationTest {
    @Test
    public void test() { //日志: hibernate.properties not found
        Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
    }

    //链: https://blog.csdn.net/u012110719/article/details/41625333
    @Test
    public void testProperties() { //日志: Loaded properties from resource hibernate.properties
        Configuration cfg = new Configuration().configure("/hibernate.cfg_p.xml");
        SessionFactory factory = cfg.buildSessionFactory();
    }

    //链: https://blog.csdn.net/ninelie/article/details/52654934
    @Test
    public void testServiceRegistry() {
        Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder(); //ServiceRegistryBuilder被弃用
        SessionFactory factory = cfg.buildSessionFactory(builder.build());
    }

    /**
     * 硬编码
     */
    @Test
    public void testJava() {
        Configuration cfg = new Configuration();
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/ibernate?serverTimezone=GMT");
        cfg.setProperty("hibernate.connection.username", "root");
        cfg.setProperty("hibernate.connection.password", "admin");

        SessionFactory factory = cfg.buildSessionFactory();
    }
}

// *.xml 需要在代码中引入, hibernate.properties不用引入
// Hibernate首先去找hibernate.properties配置文件(由日志可得)
