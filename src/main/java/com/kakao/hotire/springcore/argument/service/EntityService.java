package com.kakao.hotire.springcore.argument.service;

public interface EntityService<T> {
     T findById(final Long id);
}
