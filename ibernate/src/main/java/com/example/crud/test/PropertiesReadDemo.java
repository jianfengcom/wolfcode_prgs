package com.example.crud.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class PropertiesReadDemo {
    @Test
    public void test1() { //日志: hibernate.properties not found
        Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
    }

    @Test
    public void testProperties() { //日志: Loaded properties from resource hibernate.properties
        Configuration cfg = new Configuration().configure("/hibernate.cfg_p.xml");
        SessionFactory factory = cfg.buildSessionFactory();
    }

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
// Hibernate首先去找hibernate.properties配置文件(看日志可得)
