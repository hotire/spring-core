package com.github.hotire.springcore.bean.register.import_determinable;

import java.util.Set;

import org.springframework.boot.context.annotation.DeterminableImports;
import org.springframework.core.type.AnnotationMetadata;

public class CustomDeterminableImports implements DeterminableImports {
    @Override
    public Set<Object> determineImports(AnnotationMetadata metadata) {
        return Set.of();
    }
}
