package com.kakao.hotire.springcore.property;

import java.beans.PropertyEditorSupport;


public class EventEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(Event.builder().id(Integer.parseInt(text)).build());
    }
}
