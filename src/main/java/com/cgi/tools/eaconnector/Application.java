package com.cgi.tools.eaconnector;

import com.cgi.tools.eaconnector.service.EaPackageService;
import com.cgi.tools.eaconnector.service.EaRelationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * The entry point of the Spring Boot application.
 *
 */
@SpringBootApplication
@PropertySource(value = "file:application.properties", ignoreResourceNotFound = true)
@Configuration
public class Application implements CommandLineRunner {

    @Autowired
    private EaPackageService eaPackageService;

    @Autowired
    private EaRelationsService eaRelationsService;

    private static Logger LOG = LoggerFactory
            .getLogger(Application.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(Application.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : EaConnector {}", args);
        if(args.length == 1 && "help".equalsIgnoreCase(args[0])) {
            LOG.info("Dostepne polecenia:\n\tdelete nazwa_pakietu\n\tcheck nazwa pakietu");
            System.out.println("Dostepne polecenia:\n\tdelete nazwa_pakietu\n\tcheck nazwa_pakietu");
        }else if(args.length != 2) {
            LOG.info("Brak parametrow");
            System.out.println("Brak parametrow");
        }else if("delete".equalsIgnoreCase(args[0])) {
            eaPackageService.deletePackage(args[1]);
        }else if("check".equalsIgnoreCase(args[0])) {
            eaRelationsService.checkDependencies(args[1]);
        }
       // eaRelationsService.checkDependencies("Enterprise Model");
       // eaRelationsService.getClassifier(128256);
    }

}
