package org.spring.boot.autoconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class Main {
    /**
     * Spring Boot - AutoConfig behind the hoods
     * <p>
     * 1. How does embedded web server works
     * 2. How in memory db works
     * 3. How properties files work
     */

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(MyAppConfig.class);
    }

    @Configuration
    @Import(DefaultConfig.class)// this will import whatever is configured in DefaultConfig
    static class MyAppConfig {
    }

}
