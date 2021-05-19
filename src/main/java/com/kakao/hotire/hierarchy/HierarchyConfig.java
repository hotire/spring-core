package com.kakao.hotire.hierarchy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.kakao.hotire.hierarchy.child.ChildContext;
import com.kakao.hotire.hierarchy.parent.ParentContext;
import com.kakao.hotire.hierarchy.sibling.SiblingContext;

public class HierarchyConfig {
    public static void main(String... args) {
        final SpringApplicationBuilder appBuilder = new SpringApplicationBuilder()
                .parent(ParentContext.class).web(WebApplicationType.NONE)
                .child(ChildContext.class).web(WebApplicationType.SERVLET)
                .sibling(SiblingContext.class).web(WebApplicationType.SERVLET);
        appBuilder.run();
    }
}
