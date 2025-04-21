package chapter1_fundamentals;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 What is a servlet?
 A Servlet is a Java class that handles HTTP requests and generates responses.
  - It's part of the Java EE (Jakarta EE) specification
  - Typically runs in a Servlet container like Tomcat, Jetty, or GlassFish
  - Servlets are like the ancestors of modern web frameworks (Spring Boot, etc.)
 Although we rarely write raw servlets anymore (a bit outdated), they are still running underneath many frameworks like Spring Boot, and
 since servlet comes up a few times in the examples, let's do one quick example.
 I've covered details of servlets in my Spring Boot repository.
 */

@WebServlet("/hello")
public class A_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*
        Refer to the images A_ServletArchitecture.
        When the user types in http://localhost:8080/JavaConcurrency-1.0-SNAPSHOT/hello, the client/webserver is sending a request
        to our server (Tomcat) and parses the request.
        Then it creates a HttpServletRequest object to represent the incoming HTTP request &
        HttpservletResponse object to represent the outgoing HTTP response.
        Servlet uses req to read data from the request, such as URL, query parameters, headers etc. and
        resp to send a response back to the browser in a plain text format.
         */
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        out.println("Hello, Servlet World!");
    }
}

/**
 FYI, I'm doing a very old school coding & a terrible coding practice.
 After writing this code, it's important to add <packaging>war</packaging>  in pom.xml
 Then, run mvn clean package and I can see JavaConcurrency-1.0-SNAPSHOT.war file inside a target folder.
 Copy this file into Apachetomat\webapps.
 Then go to Apachetomcat\bin and run startup.batch.
 Go to web browser and go to localhost:8080 to check if the server's up & running.
 If so, go to localhost:8080/JavaConcurrency-1.0-SNAPSHOT/hello and I can see "Hello, Servlet World!" message.
 */
