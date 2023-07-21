package org.spring.boot.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Consider this class as a config class that would exist in one of app libraries
 * and not as class of our app
 */
@Configuration
public class DefaultConfig {

    //When this class is included in an apps configuration
    // we need to conditionally select what the web server will be (aka tomacat , jetty etc)
    // Thus we use one of the most important annotations used in the source code of
    // Spring boot, the @Conditional
    //
    @Bean
    @Conditional({TomcatClassPathCondition.class})
    public TomcatLauncher tomcatLauncher() {
        return new TomcatLauncher();
    }
}
