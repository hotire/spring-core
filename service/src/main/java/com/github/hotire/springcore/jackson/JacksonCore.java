package com.github.hotire.springcore.jackson;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JacksonCore {
    private final String name;
    private final boolean enabled;
}
