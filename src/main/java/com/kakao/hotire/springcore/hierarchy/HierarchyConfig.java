package com.kakao.hotire.springcore.hierarchy;

import org.springframework.boot.builder.SpringApplicationBuilder;

import com.kakao.hotire.child.ChildContext;
import com.kakao.hotire.springcore.Application;

public class HierarchyConfig {
    public static void main(String... args) {
        final SpringApplicationBuilder appBuilder = new SpringApplicationBuilder()
                .parent(Application.class)
                .child(ChildContext.class);
        appBuilder.run();
    }
}
