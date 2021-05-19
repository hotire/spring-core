package com.kakao.hotire.child;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.kakao.hotire.springcore.hierarchy.ParentBean;

@Component
public class ChildBean implements InitializingBean {

    @Autowired(required = false)
    private ParentBean parentBean;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(parentBean, "parentBean is parentContext");
    }
}
