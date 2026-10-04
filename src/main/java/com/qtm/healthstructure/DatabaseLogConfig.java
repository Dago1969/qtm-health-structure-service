package com.qtm.healthstructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLogConfig {

    private static final Logger log = LoggerFactory.getLogger(DatabaseLogConfig.class);

    @Value("${SPRING_DATASOURCE_URL:${spring.datasource.url:N/A}}")
    private String datasourceUrl;

    @Value("${DB_HOST:N/A}")
    private String dbHost;

    @Value("${DB_PORT:N/A}")
    private String dbPort;

    @Value("${DB_NAME:N/A}")
    private String dbName;

    @EventListener(ApplicationReadyEvent.class)
    public void logDatabaseConfiguration() {
        log.info("==================================================");
        log.info(" DATABASE CONFIGURATION LOG");
        log.info(" DB_HOST         : {}", dbHost);
        log.info(" DB_PORT         : {}", dbPort);
        log.info(" DB_NAME         : {}", dbName);
        log.info(" SPRING_DS_URL   : {}", datasourceUrl);
        log.info("==================================================");
    }
}