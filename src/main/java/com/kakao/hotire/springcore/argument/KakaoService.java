package com.kakao.hotire.springcore.argument;

public class KakaoService implements EntityService<Kakao>{

    @Override
    public Kakao findById(Long id) {
        return new Kakao(id);
    }
}
