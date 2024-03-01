package com.github.hotire.springcore.condition;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;

/**
 * @see AnnotationMetadata
 * @see ClassMetadata
 * @see org.springframework.core.type.classreading.SimpleAnnotationMetadata
 */
public interface AnnotationMetadataCore {

    /**
     * @see org.springframework.core.type.classreading.SimpleAnnotationMetadata#getClassName
     * @return
     */
    String getClassName();

}
