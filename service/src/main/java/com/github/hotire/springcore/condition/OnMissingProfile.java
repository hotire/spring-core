package com.github.hotire.springcore.condition;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Profiles;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class OnMissingProfile implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(ConditionalOnMissingProfile.class.getName());

        return Optional.ofNullable(attrs)
                       .map(it -> (List<?>) it.get("value"))
                       .map(profiles -> profiles.stream()
                                                .map(Object::toString)
                                                .map(Profiles::of)
                                                .noneMatch(profile -> context.getEnvironment().acceptsProfiles(profile)))
                       .orElse(true);
    }
}
