package com.kakao.hotire.springcore.argument.service;

import com.kakao.hotire.springcore.argument.entity.Kakao;
import org.springframework.stereotype.Service;

@Service
public class KakaoService implements EntityService<Kakao> {

    @Override
    public Kakao findById(Long id) {
        return new Kakao(id);
    }
}
