package org.spring.boot.autoconfig;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.annotation.PostConstruct;

public class TomcatLauncher {

    //with this annotation the method will be executed once the constructor of this class is called
    @PostConstruct
    public void launch() throws LifecycleException {
        // 1. once dependency added we can instantiate the Tomcat
        final Tomcat tomcat = new Tomcat();

        // http://localhost:8081/ --> to have this running we need
        tomcat.setPort(8081);//to define the port that server runs
        final Context context = tomcat.addContext("/", null);// to define the context path ( usually is /)
        // and a servlet that handles the requests in /login
        Tomcat.addServlet(context, "helloServlet", new HelloServlet());
        // Spring boot does not use the HelloServlet of course
        // it uses the Dispatcher servlet that handles all the requests to the app and directs them to the appropriate controller

        // and we need the mapping of the servlet to the path
        context.addServletMappingDecoded("/", "helloServlet");

        tomcat.start(); //this will start tomcat but then it is shutting down immediately
        // we need a separate thread that prevents the tomcat's shut down
        new Thread(() -> tomcat.getServer().await()).start();
    }

}
