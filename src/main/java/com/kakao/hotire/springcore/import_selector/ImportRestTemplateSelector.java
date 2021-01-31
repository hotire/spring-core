package com.kakao.hotire.springcore.import_selector;

import java.util.Map;
import java.util.Objects;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.ImmutableMap;

public class ImportRestTemplateSelector implements ImportSelector {

  private final Map<Mode, String[]> restTemplateMap;

  public ImportRestTemplateSelector() {
    restTemplateMap = ImmutableMap.of(Mode.NONE, new String[]{RestTemplate.class.getName()},
      Mode.ASYNC, new String[]{AsyncRestTemplate.class.getName()},
      Mode.ALL, new String[]{RestTemplate.class.getName(), AsyncRestTemplate.class.getName()});
  }

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    Map<String, Object> metaData = importingClassMetadata.getAnnotationAttributes(
      EnableRestTemplate.class.getName());
    final AnnotationAttributes attributes = AnnotationAttributes.fromMap(metaData);
    Objects.requireNonNull(attributes);

    final Mode mode = attributes.getEnum("mode");
    return restTemplateMap.get(mode);
  }
}
