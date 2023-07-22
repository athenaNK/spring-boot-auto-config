package org.spring.boot.autoconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    /**
     * Spring Boot - AutoConfig behind the hoods
     * <p>
     * 1. How does embedded web server works
     * 2. How in memory db works
     * 3. How properties files work
     */

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyAppConfig.class);
        final DataSource dataSource = ctx.getBean(DataSource.class);

        try (Connection connection = dataSource.getConnection()) {
            System.out.println("====== connection = " + connection);
            System.out.println("====== connection.isValid = " + connection.isValid(5000));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Configuration
    @Import(DefaultConfig.class)// this will import whatever is configured in DefaultConfig
    static class MyAppConfig {
    }

}
