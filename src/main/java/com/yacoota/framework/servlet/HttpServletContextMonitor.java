package com.yacoota.framework.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
@Slf4j
public class HttpServletContextMonitor implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.trace("ServletContextListener创建监测，servlet context initialized: {}", sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.trace("ServletContextListener销毁监测，servlet context destoryed: {}", sce.getServletContext().getServerInfo());
    }
}

