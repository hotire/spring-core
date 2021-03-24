package com.kakao.hotire.springcore.validation;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Validation {
    @CustomValidation
    @Size(min = 3)
    private Set<Entry> entryList;

    @NotEmpty
    private String name;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Entry {
        private String key;
        private String value;
    }
}
