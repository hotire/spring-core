# SPI

Service Provider Interface 

서비스 발견 메커니즘 으로 설정 을 바탕 으로 실행 할 때 지정 한 서 비 스 를 불 러 올 수 있 습 니 다.

샤용자가 구현해야 할 Interface를 정의한다.

SPI 사용자(보통은 driver vendor)가 자신의 환경에 맞는 구현체를 직접 정의하여 제공하면 SPI를 제공해준 service에서는 제공 받은 구현체를 불러다 사용하는 형태로 동작한다.

https://www.baeldung.com/java-spi