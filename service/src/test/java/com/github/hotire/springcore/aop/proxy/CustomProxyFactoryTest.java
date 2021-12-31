package com.github.hotire.springcore.aop.proxy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

class CustomProxyFactoryTest {

    public static class Service {
        public String doService() {
            return "hello";
        }

        @Override
        public String toString() {
            return "Service";
        }
    }

    @Test
    void getProxy() {
        // given
        final Service bean = new Service();
        final ProxyFactory proxyFactory = new ProxyFactory(bean);
        proxyFactory.addAdvice((AfterReturningAdvice) (returnValue, method, args, target) -> System.out.println("returnValue : " + returnValue));


        // when
        final Object proxy = proxyFactory.getProxy();

        // then
        assertThat(proxy).isInstanceOf(Service.class);
        ((Service) proxy).doService();
    }
}