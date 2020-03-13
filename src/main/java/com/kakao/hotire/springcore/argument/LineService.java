package com.kakao.hotire.springcore.argument;

public class LineService implements EntityService<Line> {

    @Override
    public Line findById(Long id) {
        return new Line(id);
    }
}
