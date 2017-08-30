package pactera.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * System Context Listener
 *
 * @author Steven
 */
public class ContextListener extends ContextLoaderListener {

    private static final Logger logger = LoggerFactory.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {

        super.contextInitialized(event);

        try {
            SystemInitializer initializer = SystemInitializer.getInstance();
            initializer.init(event);

        } catch (Exception e) {
            logger.info("ContextListener Error : " + e.getMessage());
            System.exit(1);
        }
    }
}
