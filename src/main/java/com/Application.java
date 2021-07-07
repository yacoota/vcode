package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.yacoota.business.*.mapper")
@EnableTransactionManagement
@EnableCaching
@EnableRedisHttpSession
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
