package com.yacoota.framework.server;

import io.undertow.server.HttpServerExchange;
import io.undertow.server.session.Session;
import io.undertow.server.session.SessionListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HttpServerSessionMonitor implements SessionListener {

    @Override
    public void sessionCreated(final Session session, final HttpServerExchange exchange) {
        log.info("SessionListener创建监测，session created: {}, {}", session.getId(), exchange.toString());
    }

    @Override
    public void sessionDestroyed(final Session session, final HttpServerExchange exchange, SessionDestroyedReason reason) {
        log.info("SessionListener销毁监测，session destoryed: {}, {}, {}", session.getId(), exchange.toString(), reason.toString());
    }

    @Override
    public void attributeAdded(final Session session, final String name, final Object value) {
        log.info("SessionListener属性增加，attribute added: {}, {}, {}", session.getId(), name, value.toString());
    }

    @Override
    public void attributeUpdated(final Session session, final String name, final Object newValue, final Object oldValue) {
        log.info("SessionListener属性更新，attribute updated: {}, {}, {}, {}", session.getId(), name, newValue.toString(), oldValue.toString());
    }

    @Override
    public void attributeRemoved(final Session session, final String name, final Object oldValue) {
        log.info("SessionListener属性移除，attribute removed: {}, {}, {}", session.getId(), name, oldValue.toString());
    }

    @Override
    public void sessionIdChanged(final Session session, final String oldSessionId) {
        log.info("SessionListener改变更新，session id changed: {}, {}", session.getId(), oldSessionId);
    }

}
