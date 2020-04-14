package com.kakao.hotire.springcore.log;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.MDC;
import org.slf4j.spi.MDCAdapter;

import java.util.Map;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MDCUtils {

    private final MDCAdapter mdcAdapter = MDC.getMDCAdapter();

    public void put(String key, String value) {
        mdcAdapter.put(key, value);
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(mdcAdapter.get(key));
    }

    public void remove(String key) {
        mdcAdapter.remove(key);
    }

    public void clear() {
        mdcAdapter.clear();;
    }

    public Map<String, String> getCopyOfContextMap() {
        return mdcAdapter.getCopyOfContextMap();
    }

    public void putAll(Map<String, String> map) {
        map.forEach(mdcAdapter::put);
    }
}
