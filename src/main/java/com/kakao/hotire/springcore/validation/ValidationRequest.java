package com.kakao.hotire.springcore.validation;

import javax.validation.constraints.NotEmpty;

public class ValidationRequest {
    @NotEmpty
    private String key;
    @NotEmpty
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
