package com.kakao.hotire.springcore.argument.service;

import org.springframework.stereotype.Service;

import com.kakao.hotire.springcore.argument.entity.Line;

@Service
public class LineService implements EntityService<Line> {

    @Override
    public Line findById(Long id) {
        return new Line(id);
    }
}
