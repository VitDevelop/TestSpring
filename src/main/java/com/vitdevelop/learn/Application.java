package com.vitdevelop.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by CIC on 12.06.2015.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.vitdevelop.learn")
@EntityScan(basePackages = "com.vitdevelop.learn.core.domain")
@EnableJpaRepositories(basePackages = "com.vitdevelop.learn.core.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
