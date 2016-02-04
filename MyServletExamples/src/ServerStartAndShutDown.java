

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServerStartAndShutDown
 *
 */
@WebListener
public class ServerStartAndShutDown implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { 
        
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         for(int i = 1; i<=100; i++){
        	 System.out.println("I is "+i);
        	 try{
        	 Thread.sleep(30);
        	 }
        	 catch(Exception e){
        		 System.out.println(e);
        	 }
        	 
         }
    }
	
}
