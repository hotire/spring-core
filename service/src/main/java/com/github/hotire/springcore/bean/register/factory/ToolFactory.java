package com.github.hotire.springcore.bean.register.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

/**
 * @see org.springframework.beans.factory.support.AbstractBeanFactory#isTypeMatch(String, ResolvableType, boolean)
 * @see org.springframework.beans.factory.support.FactoryBeanRegistrySupport#getTypeForFactoryBean(FactoryBean)
 * getObjectType -> FactoryBean Proxy getObjectType && getObject
 */
@Component
public class ToolFactory implements FactoryBean<Tool> {
    private Long factoryId;
    private Long toolId;

    @Override
    public Tool getObject() throws Exception {
        return new Tool(toolId);
    }

    @Override
    public Class<?> getObjectType() {
        return Tool.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
