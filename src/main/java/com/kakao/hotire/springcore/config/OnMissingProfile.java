package com.kakao.hotire.springcore.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Profiles;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

public class OnMissingProfile implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(ConditionalOnMissingProfile.class.getName());

        return Optional.ofNullable(attrs)
                       .map(it -> (List<?>) it.get("value"))
                       .map(it -> {
                           System.out.println(it);
                           return it;
                       })
                       .map(profiles -> profiles.stream()
                                                .map(Object::toString)
                                                .map(Profiles::of)
                                                .filter(profile -> context.getEnvironment().acceptsProfiles(profile))
                                                .findAny()
                                                .map(it -> Boolean.FALSE)
                                                .orElse(true))
                       .orElse(true);
    }
}
