package listener;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import utils.DBUtils;
//@WebListener
public class BookShopListener implements ServletContextListener {

    public BookShopListener() {
    }
    public void contextInitialized(ServletContextEvent sce)  { 
       System.out.println("contextInitialized");
       ServletContext sc = sce.getServletContext();
       Properties p  = new Properties();
       
       String driver = sc.getInitParameter("DRIVER");
       p.setProperty("Driver", driver);
       
	   String url = sc.getInitParameter("URL");
	   p.setProperty("Url", url);
	   
	   String user = sc.getInitParameter("USER");
	   p.setProperty("User", user);
	   
	   String password = sc.getInitParameter("PASSWORD");
	   p.setProperty("Password", password);
	   
	   DBUtils.setProperties(p);
		
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("contextDestroyed");
    }
}
