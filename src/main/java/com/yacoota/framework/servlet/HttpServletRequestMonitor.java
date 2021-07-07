package com.yacoota.framework.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class HttpServletRequestMonitor implements ServletRequestListener {

    public static final Map<String, Long> sessions = new ConcurrentHashMap<>();

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        sessions.putIfAbsent(request.getSession().getId(), request.getSession().getLastAccessedTime());
        log.trace("ServletRequestListener创建监测，servlet request initialized: {} \t; time: {}", request.getSession().getId(), request.getSession().getLastAccessedTime());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        sessions.replace(request.getSession().getId(), request.getSession().getLastAccessedTime());
        log.trace("ServletRequestListener销毁监测，servlet request destoryed: {} \t; time: {}", request.getSession().getId(), request.getSession().getLastAccessedTime());
    }

}
