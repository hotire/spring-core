# DI

생성자 주입의 경우 BeanFactory 에 의해 빈을 생성할 때 ConstructorResolver 에 의해 필요한 의존성들을 Beanfactory에서 가져와 생성하게 된다. 

필드, 세터 주입의 경우는 popoluateBean 과정에서 InstantiationAwareBeanPostProcessor 의 구현체 

AutowiredAnnotationBeanPostProcessor에 의해 필드와 메서드에 존재하는 @Autowired annotation을 찾아 주입해주게 된다.

## Constructor

### org.springframework.beans.factory.support.ConstructorResolver

- autowireConstructor

## Autowired

### org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#populateBean(String, RootBeanDefinition, BeanWrapper)

### org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor


