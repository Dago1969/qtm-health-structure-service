package com.qtm.healthstructure;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class QtmHealthStructureApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(QtmHealthStructureApplication.class)
        .listeners(new DatabaseLogListener())
        .run(args);
    }
}