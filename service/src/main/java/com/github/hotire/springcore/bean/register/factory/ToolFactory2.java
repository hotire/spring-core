package com.github.hotire.springcore.bean.register.factory;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class ToolFactory2 extends AbstractFactoryBean<Tool> {
    private Long factoryId;
    private Long toolId;

    @Override
    public Class<?> getObjectType() {
        return Tool.class;
    }

    @Override
    protected Tool createInstance() throws Exception {
        return new Tool(toolId);
    }
}

