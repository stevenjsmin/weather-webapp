package pactera.framework;

import org.apache.commons.configuration.XMLConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * System Initializer
 *
 * @author Steven Min
 */
public class SystemInitializer {

    private static final Logger logger = LoggerFactory.getLogger(SystemInitializer.class);

    private static SystemInitializer singleton;

    private SystemInitializer() {
    }

    public static SystemInitializer getInstance() {
        if (singleton == null) {
            singleton = new SystemInitializer();
        }
        return singleton;
    }

    public void init(ServletContextEvent event) throws Exception {

        System.out.println();
        System.out.println();

        logger.info("Pactera Weather Web-application Initialize............................");

        ServletContext ctx = event.getServletContext();
        WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(ctx);

        try {
            XMLConfiguration config = new XMLConfiguration();
            config.load(SystemInitializer.class.getResourceAsStream("/configuration.xml"));
            Ctx.conf = config;

            logger.info("  > Configurator : " + Ctx.conf.getRoot().getName());

        } catch (Exception e) {
            logger.info("Pactera Weather Web-application Initialize Failure ...... : " + e.getMessage());
            throw e;
        }
        logger.info("Pactera Weather Web-application Initialize Finished ......");

        System.out.println();
        System.out.println();

    }
}
