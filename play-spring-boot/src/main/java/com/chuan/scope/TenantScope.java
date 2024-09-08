package com.chuan.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xucy-e
 */
@Component
public class TenantScope implements Scope {
    private final Map<String, Object> scopeContext = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return scopeContext.computeIfAbsent(name, key -> objectFactory.getObject());
    }

    @Override
    public Object remove(String name) {
        return scopeContext.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
