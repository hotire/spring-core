package com.github.hotire.springcore.argument.service;

public interface EntityService<T> {
     T findById(final Long id);
}
