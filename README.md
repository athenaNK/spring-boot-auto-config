# springBootAutoConfig
This repo contains examples on how Spring Autoconfiguration works using examples of Tomcat and H2 db.  
We create the tomcat and h2 bean like Spring boot could do under the hood.
It is a simple example of what is triggered and done when @EnableAutoconfiguration is included.

When you use the **@EnableAutoConfiguration** annotation in your Spring Boot application, it triggers Spring Boot's auto-configuration mechanism. 
This mechanism automatically configures various components based on the classpath and the dependencies present in your project.

_Spring Boot's auto-configuration process scans for specific classes, known as auto-configuration classes,
that are defined within the Spring Boot actual implementation (in the Spring Boot framework itself).
These auto-configuration classes contain configuration logic and bean definitions that set up various components
and configurations based on the presence of certain dependencies or properties._

When your application includes specific dependencies, Spring Boot will automatically detect those dependencies and activate relevant auto-configuration classes. 
These auto-configuration classes are designed to be conditionally enabled based on the presence of specific classes or properties in the classpath. 
They ensure that only the relevant configurations are applied, reducing the boilerplate code required for common use cases.

For example, if your application includes the Spring Data JPA dependency, 
Spring Boot will automatically detect this and activate the auto-configuration class responsible for setting up the 
JPA-related configurations, such as a DataSource, EntityManager, transaction management, etc.

By enabling auto-configuration, you benefit from a **<sub>"convention over configuration"</sub>** approach, 
where Spring Boot automatically configures sensible defaults for your application based on what it detects in the classpath. 
Of course, you can always override these auto-configurations by providing your own custom configurations.

Overall, Spring Boot's auto-configuration mechanism is a powerful feature that greatly simplifies the setup and configuration of Spring applications, 
allowing developers to focus more on building business logic and less on boilerplate configuration.
