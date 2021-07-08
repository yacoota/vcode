package com.yacoota.business.demo.task;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/** 在线cron表达式生成器地址：http://cron.qqe2.com/ **/
@Component
@Slf4j
public class DemoTask {

    @Autowired
    private ApplicationContext ctx;

    @Scheduled(cron = "0 0/10 * * * ?")
    public void execute() {
        log.info("系统自动任务执行execute：{}, {}, {}, {}, {}", IdUtil.getSnowflake(1, 1).nextIdStr(), RandomStringUtils.random(30, true, true).toUpperCase(), StringUtils.leftPad(String.valueOf(ThreadLocalRandom.current().nextInt(0, 1000)), 3, "0"), this, ctx);
    }

    @Scheduled(cron = "${spring.task.schedules.cron.demo.task1}")
    @Async("executor")
    public void execute1() throws InterruptedException {
        log.trace("系统自动任务执行execute-task1-start：{}", this);
        TimeUnit.SECONDS.sleep(30);
        log.trace("系统自动任务执行execute-task1-end：{}", ThreadLocalRandom.current().nextInt(0, 100));
    }

    @Scheduled(cron = "${spring.task.schedules.cron.demo.task2}")
    @Async("executor")
    public void execute2() throws InterruptedException {
        log.trace("系统自动任务执行execute-task2-start：{}", this);
        TimeUnit.SECONDS.sleep(30);
        log.trace("系统自动任务执行execute-task2-end：{}", ThreadLocalRandom.current().nextInt(0, 100));
    }

    @Scheduled(cron = "0/30 * * * * ?")
    public void upload() {
        log.trace("系统自动任务执行execute-upload：{}, {}", this, ctx);
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void download() {
        log.trace("系统自动任务执行execute-download：{}, {}", this, ctx);
    }
}
