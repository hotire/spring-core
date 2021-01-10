package com.kakao.hotire.springcore.argument.service;

import org.springframework.stereotype.Service;

import com.kakao.hotire.springcore.argument.entity.Kakao;

@Service
public class KakaoService implements EntityService<Kakao> {

    @Override
    public Kakao findById(Long id) {
        return new Kakao(id);
    }
}
