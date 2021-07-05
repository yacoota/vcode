package com.yacoota.framework.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

@Component
@Slf4j
public class HttpServletSessionMonitor implements HttpSessionListener, HttpSessionIdListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("HttpSessionListener创建监测，session created: {}, \t; time: {}", se.getSession().getId(), System.currentTimeMillis());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("HttpSessionListener销毁监测，session destoryed: {}, \t; time: {}", se.getSession().getId(), System.currentTimeMillis());
    }

    @Override
    public void sessionIdChanged(HttpSessionEvent se, String oldSessionId) {
        log.info("HttpSessionIdListener监测事件，session id changed: {} -- {} \t; time: {}", se.getSession().getId(), oldSessionId, System.currentTimeMillis());
    }

}

