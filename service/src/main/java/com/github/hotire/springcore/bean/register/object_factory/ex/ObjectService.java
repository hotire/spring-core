package com.github.hotire.springcore.bean.register.object_factory.ex;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObjectService {

    private final ObjectFactory<ObjectConverter> converterObjectFactory;

    private final ObjectConverter objectConverter;

    @PostConstruct
    public void init() {
        Assert.isTrue(converterObjectFactory.getObject() == objectConverter, "factory bean is diff");
    }

}
