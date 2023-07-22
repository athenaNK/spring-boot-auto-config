package org.spring.boot.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.Driver;

/**
 * Consider this class as a config class that would exist in one of app libraries
 * and not as class of our app
 */
@Configuration
// Annotation providing a convenient and declarative mechanism for adding a PropertySource to Spring's Environment.
// To be used in combination with @Configuration classes.
@PropertySource("classpath:application.properties")
public class DefaultConfig {

    //When this class is included in an apps configuration
    // we need to conditionally select under which conditions tomcat will run.
    // Thus we use one of the most important annotations used in the source code of
    // Spring boot, the @Conditional
    //Conditionals are executed first, before @Bean
    @Bean
    @Conditional({TomcatClassPathCondition.class})
    public TomcatLauncher tomcatLauncher() {
        return new TomcatLauncher();
    }


    //how will get the properties from application.properties
    //one way is to inject spring env and use the getProperty method
    @Bean
    @Conditional(DataSourcePropertiesSetConditional.class)
    public DataSource dataSource(Environment env) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String url = env.getProperty("spring.datasource.url");
        Driver driver = (Driver) Class.forName(env.getProperty("spring.datasource.driver-class-name"))
                .getDeclaredConstructor()
                .newInstance();


        return new SimpleDriverDataSource(driver, url);
    }
}
