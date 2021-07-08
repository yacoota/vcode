package com.yacoota.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class Configuration {

    @Bean("executor")
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(99999);
        executor.setThreadNamePrefix("my-executor-service-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Bean
    public TaskScheduler scheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(Runtime.getRuntime().availableProcessors()/2+1);
        scheduler.setRemoveOnCancelPolicy(true);
        scheduler.setThreadNamePrefix("my-scheduler-service-");
        scheduler.initialize();
        return scheduler;
    }

}
