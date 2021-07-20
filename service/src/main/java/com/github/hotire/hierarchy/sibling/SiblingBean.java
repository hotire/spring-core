package com.github.hotire.hierarchy.sibling;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.github.hotire.hierarchy.child.ChildBean;
import com.github.hotire.hierarchy.parent.ParentBean;

@Component
public class SiblingBean implements InitializingBean {

    @Autowired(required = false)
    private ParentBean parentBean;

    @Autowired(required = false)
    private ChildBean childBean;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(parentBean, "parentBean is parentContext");
        Assert.isNull(childBean, "childBean is childContext");
    }
}
