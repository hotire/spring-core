package com.kakao.hotire.springcore.argument;

public interface EntityService<T> {
     T findById(final Long id);
}
