package com.github.hotire.hierarchy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.github.hotire.hierarchy.child.ChildContext;
import com.github.hotire.hierarchy.parent.ParentContext;
import com.github.hotire.hierarchy.sibling.SiblingContext;

public class HierarchyConfig {
    public static void main(String... args) {
        final SpringApplicationBuilder appBuilder = new SpringApplicationBuilder()
                .parent(ParentContext.class).web(WebApplicationType.NONE)
                .child(ChildContext.class).web(WebApplicationType.SERVLET)
                .sibling(SiblingContext.class).web(WebApplicationType.SERVLET);
        appBuilder.run();
    }
}
