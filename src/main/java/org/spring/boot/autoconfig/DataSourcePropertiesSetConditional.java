package org.spring.boot.autoconfig;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Conditional ensures that only when the required properties are defined and do have values the
 * datasource bean will be created
 * <p>
 * In spring boot impl we find several conditional annotations such as
 * ConditionalOnBean -> do something if the bean is created
 * ConditionalOnMissingBean -> only if the bean defined in this annotation execute the code of method marked with the annitaion
 * ConditionalOnProperty
 * ConditionalOnResource
 * ConditionalOnClass -> only when the classes in annotation exist in classpath then execute the method
 * ConditionalOnJava -> e.g does domething when specific java version is used
 * ConditionalOnWebApplication -> am I running on web app or not
 */
public class DataSourcePropertiesSetConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().containsProperty("spring.datasource.url")
                && !context.getEnvironment().getProperty("spring.datasource.url").isEmpty()
                &&
                context.getEnvironment().containsProperty("spring.datasource.driver-class-name")
                && !context.getEnvironment().getProperty("spring.datasource.driver-class-name").isEmpty();
    }
}
