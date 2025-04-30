package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

import web.handler.LoginServlet;
import web.handler.RegistrationServlet;
import web.handler.WelcomeServlet;

/**
 * HTTP server. Starts server and registers Java Servlets to URL routes.
 */
public class MyServer {

    private static int PORT = 8082;

    public void start() throws Exception {
        Server server = new Server(PORT);

        // ✅ Static file handler
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("static"); // <- Make sure /static/login.html exists in project root
        resourceHandler.setDirectoriesListed(true);

        // ✅ Servlet handler
        ServletContextHandler servletHandler = new ServletContextHandler();
        servletHandler.addServlet(WelcomeServlet.class, "/");
        servletHandler.addServlet(LoginServlet.class, "/login");
        servletHandler.addServlet(RegistrationServlet.class, "/reg");

        // ✅ Combine both handlers (static handler goes first)
        HandlerList handlers = new HandlerList();
        handlers.addHandler(resourceHandler);
        handlers.addHandler(servletHandler);

        server.setHandler(handlers);

        System.out.println("✅ Server started at http://127.0.0.1:" + PORT);
        server.start();
    }

    public static void main(String[] args) throws Exception {
        new MyServer().start();
    }
}