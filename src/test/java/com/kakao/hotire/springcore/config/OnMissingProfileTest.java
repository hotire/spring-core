package com.kakao.hotire.springcore.config;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OnMissingProfileTest {

    @MethodSource("provideArguments")
    @ParameterizedTest
    void matches(final List<String> profiles, final List<String> activeProfiles, final boolean expected) {
        // given
        final Environment environment = new MockEnvironment() {
            @Override
            protected Set<String> doGetActiveProfiles() {
             return Sets.newHashSet(activeProfiles);
            }
        };
        final ConditionContext context = mock(ConditionContext.class);
        final MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        final AnnotatedTypeMetadata metadata = mock(AnnotatedTypeMetadata.class);
        final OnMissingProfile onMissingProfile = new OnMissingProfile();
        multiValueMap.addAll("value", profiles);

        // when
        when(context.getEnvironment()).thenReturn(environment);
        when(metadata.getAllAnnotationAttributes(ConditionalOnMissingProfile.class.getName())).thenReturn(multiValueMap);
        final boolean result = onMissingProfile.matches(context, metadata);

        // then
        assertThat(result).isEqualTo(expected);
    }


    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(Lists.newArrayList("beta"), Lists.newArrayList("beta"), false),
                Arguments.of(Lists.newArrayList("beta"), Lists.newArrayList("alpha"), true)
        );
    }
}