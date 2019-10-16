package com.kakao.hotire.springcore.di;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ContainerServiceTest {

  @Test
  public void getBean() {
    // When
    TestController testController = ContainerService.getBean(TestController.class);

    // Then
    assertThat(testController).isNotNull();
  }

  @Test
  public void getBeanIsSingleTon() {
    // When
    TestController testController = ContainerService.getBean(TestController.class);
    TestController testController2 = ContainerService.getBean(TestController.class);

    // Then
    assertThat(testController).isEqualTo(testController2);
  }

  @Test
  public void di() {
    // When
    TestController testController = ContainerService.getBean(TestController.class);
    TestService testService = ContainerService.getBean(TestService.class);

    // Then
    assertThat(testController.getTestService()).isNotNull();
    assertThat(testController.getTestService()).isEqualTo(testService);
  }
}