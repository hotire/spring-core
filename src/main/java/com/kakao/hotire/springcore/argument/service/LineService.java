package com.kakao.hotire.springcore.argument.service;

import com.kakao.hotire.springcore.argument.entity.Line;
import org.springframework.stereotype.Service;

@Service
public class LineService implements EntityService<Line> {

    @Override
    public Line findById(Long id) {
        return new Line(id);
    }
}
