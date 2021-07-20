package com.github.hotire.springcore.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class ToolFactory implements FactoryBean<com.github.hotire.springcore.factory.Tool> {
    private Long factoryId;
    private Long toolId;

    @Override
    public com.github.hotire.springcore.factory.Tool getObject() throws Exception {
        return new com.github.hotire.springcore.factory.Tool(toolId);
    }

    @Override
    public Class<?> getObjectType() {
        return Tool.class;
    }

}
