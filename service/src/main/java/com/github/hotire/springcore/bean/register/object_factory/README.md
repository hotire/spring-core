# ObjectFactory

Object 인스턴스를 반환할 수 있는 팩토리를 정의합니다. (공유되거나, 독릭접으로 호출이 가능할 때 )

일반적으로 새 인스턴스(프로토타입)를 반환할 때 사용된다. 

FactoryBean 와 유사하지만, 대게 FactoryBean SPI instances를 제공하는 목적이다. 

ObjectFactory가 주입되어서 ObjectFactory의 API 를 사용할 수 있다. 

## ObjectProvider implement ObjectFactory