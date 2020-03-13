package com.github.jan222ik.di.own;

import java.util.HashMap;

public abstract class AbstractModule implements IModule {
    private HashMap<Class<?>, Class<?>> mappings = new HashMap<>();

    protected <T> void map(Class<T> interfaceType, Class<? extends T> implType) {
        if (interfaceType == null) throw new NullPointerException("Interface type may not be null");
        if (implType == null) throw new NullPointerException("Implementation type may not be null");
        // TODO Assert types
        mappings.put(interfaceType, implType);
    }

    @Override
    public <T> Class<? extends T> getMapping(Class<T> interfaceType) {
        System.out.println("interfaceType = " + interfaceType);
        if (interfaceType == null) throw new NullPointerException("Interface type may not be null");
        Class<?> implType = mappings.get(interfaceType);
        return implType.asSubclass(interfaceType);
    }

    @Override
    public String toString() {
        return "AbstractModule{" +
                "mappings=" + mappings +
                '}';
    }
}