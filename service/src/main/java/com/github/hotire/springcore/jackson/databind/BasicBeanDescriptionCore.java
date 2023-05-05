package com.github.hotire.springcore.jackson.databind;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;

/**
 * Serializer 및 Deserializer 구성을 돕기 위한 ClassIntrospector에서 수집한 정보의 기본 컨테이너
 * @see BeanDescription;
 * @see BasicBeanDescription
 */
public interface BasicBeanDescriptionCore {

    /**
     * @see BasicBeanDescription#findJsonValueAccessor()
     */
    AnnotatedMember findJsonValueAccessor();
}
