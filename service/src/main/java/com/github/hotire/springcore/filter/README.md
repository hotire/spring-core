# Filter

FilterRegistrationBean 생

ApplicationContext.refresh -> ServletWebServerApplicationContext.onRefresh -> createWebServer

getSelfInitializer 호출  ServletContextInitializerBeans에 의해서 호출된다. 

