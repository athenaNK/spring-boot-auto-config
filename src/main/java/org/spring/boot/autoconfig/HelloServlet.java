package org.spring.boot.autoconfig;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

//this is the servlet we have assigned for context path / in tomcat.
// Once someone hits that path local datetime will be returned
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<html> " + LocalDateTime.now() + "</html>");
    }
}
