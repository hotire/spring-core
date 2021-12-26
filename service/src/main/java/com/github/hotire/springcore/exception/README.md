# Exception 

## MVC

### Spring DispatcherServlet의 내부 속으로 - 5 고급편(예외 처리 - @ControllerAdvice  동작 원리)

- https://blog.naver.com/gngh0101/221738449583


### ErrorController

- https://supawer0728.github.io/2019/04/04/spring-error-handling/



### StandardHostValve

custom method 

~~~java 
RequestDispatcher rd =
                servletContext.getRequestDispatcher(errorPage.getLocation());
rd.forward(request.getRequest(), response.getResponse());
~~~



