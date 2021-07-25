package com.github.hotire.springcore.bean.register.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class ToolFactory implements FactoryBean<com.github.hotire.springcore.bean.register.factory.Tool> {
    private Long factoryId;
    private Long toolId;

    @Override
    public com.github.hotire.springcore.bean.register.factory.Tool getObject() throws Exception {
        return new com.github.hotire.springcore.bean.register.factory.Tool(toolId);
    }

    @Override
    public Class<?> getObjectType() {
        return Tool.class;
    }

}
