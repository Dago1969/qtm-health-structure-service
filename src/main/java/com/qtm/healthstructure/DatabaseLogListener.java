package com.qtm.healthstructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

public class DatabaseLogListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private static final Logger log = LoggerFactory.getLogger(DatabaseLogListener.class);

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment env = event.getEnvironment();

        String dbHost = env.getProperty("DB_HOST", "N/A");
        String dbPort = env.getProperty("DB_PORT", "N/A");
        String dbName = env.getProperty("DB_NAME", "N/A");
        String datasourceUrl = env.getProperty("SPRING_DATASOURCE_URL", 
                               env.getProperty("spring.datasource.url", "N/A"));

        log.info("==================================================");
        log.info(" EARLY DATABASE CONFIGURATION LOG");
        log.info(" DB_HOST         : {}", dbHost);
        log.info(" DB_PORT         : {}", dbPort);
        log.info(" DB_NAME         : {}", dbName);
        log.info(" SPRING_DS_URL   : {}", datasourceUrl);
        log.info("==================================================");
    }
}