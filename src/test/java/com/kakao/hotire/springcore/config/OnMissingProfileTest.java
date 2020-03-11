package com.kakao.hotire.springcore.config;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OnMissingProfileTest {

    @MethodSource("provideArguments")
    @ParameterizedTest
    void matches(final List<String> profiles, final List<Profiles> activeProfiles) {
        // given
        final Environment environment = new MockEnvironment() {
            @Override
            public boolean acceptsProfiles(Profiles profiles) {
                return activeProfiles.stream().anyMatch(it -> it.equals(profiles));
            }
        };
        final ConditionContext context = mock(ConditionContext.class);
        final MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        final AnnotatedTypeMetadata metadata = mock(AnnotatedTypeMetadata.class);
        final OnMissingProfile onMissingProfile = new OnMissingProfile();


        multiValueMap.add("value", profiles);

        // when
        when(context.getEnvironment()).thenReturn(environment);
        when(metadata.getAllAnnotationAttributes(ConditionalOnMissingProfile.class.getName())).thenReturn(multiValueMap);
        onMissingProfile.matches(context, metadata);
    }


    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(Lists.newArrayList("beta"), Lists.newArrayList(Profiles.of("beat")))
        );
    }




}