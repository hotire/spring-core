package com.github.hotire.hierarchy.parent;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.github.hotire.hierarchy.child.ChildBean;

@Component
public class ParentBean implements InitializingBean {
    @Autowired(required = false)
    private ChildBean childBean;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.isNull(childBean, "childBean is childContext");
    }
}
