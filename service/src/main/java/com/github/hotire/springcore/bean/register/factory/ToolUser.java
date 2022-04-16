package com.github.hotire.springcore.bean.register.factory;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ToolUser {
    private final Tool toolFactory;
    private final Tool toolFactory2;
    private final AbstractFactoryBean<Tool> factoryBean;

    @PostConstruct
    public void init() throws Exception {
        Assert.isTrue(factoryBean.getObject() == toolFactory2, "factory bean is diff");
    }

}
