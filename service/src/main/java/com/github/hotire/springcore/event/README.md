# EntityEventListener

- EventListener Bean 등록 과정 : https://blog.naver.com/gngh0101/222022197174

## EventListenerMethodProcessor

- BeanFactoryPostProcessor : EventListenerFactory 주입 받는다. 

- SmartInitializingSingleton : ApplicationContext finishBeanFactoryInitialization 에서 beanFactory.preInstantiateSingletons 호출한다. 

afterSingletonsInstantiated 호출해준다. 

- afterSingletonsInstantiated : EventListener Annotation 있는 경우  EventListenerFactory 을 통해 createApplicationListener 생성한다.

## DefaultEventListenerFactory : EventListenerFactory

- AnnotationConfigUtils 에 의해 기본으로 추가된다. 

## TransactionalEventListenerFactory : EventListenerFactory

- autoConfig로 추가된다.

## ApplicationListenerMethodTransactionalAdapter

TransactionalEventListenerFactory 에 의해 ApplicationListenerMethodTransactionalAdapter 생성된다. 

- onApplicationEvent 시에 바로 실행하는 것이 아니라 

TransactionSynchronizationManager 에 TransactionSynchronizationEventAdapter 등록한다.

## TransactionSynchronizationEventAdapter : TransactionSynchronization

- 각각의 Phase 마다 event를 실행시킨다.

## EventPublishingRepositoryProxyPostProcessor

- Event publish 하는 곳이다.

- jpaRepository 생성시 EventPublishingRepositoryProxyPostProcessor 주입해준다. 

EventPublishingMethodInterceptor aop를 걸게된다.

- save 메서드로 시작할 경우 publishEventsFrom 을 통해 reflection을 통해 Event를 발행한다.

## TransactionManager 

- commit 
- rollback 

- triggerBeforeCommit
- triggerAfterCommit

TransactionSynchronizationManager 을 통해 synchronizations 을 가져와 호출해준다.

## TransactionSynchronizationManager

- getSynchronizations

## TransactionSynchronization

- beforeCommit









