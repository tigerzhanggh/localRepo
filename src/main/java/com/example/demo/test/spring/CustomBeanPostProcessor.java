package com.example.demo.test.spring;

import com.example.demo.test.bean.MyBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/*
每个bean初都会调用
接口定义了两个基本的Bean初始化回调方法，在属性赋值前后执行。
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    /**
    在 Bean 初始化方法（如 @PostConstruct、InitializingBean.afterPropertiesSet 或自定义初始化方法）调用之前执行；
     返回的对象将是实际注入到容器中的 Bean，如果返回 null，则该 Bean 不会被注册。可用于创建代理类
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean) {
            System.out.println("bean初始化前: " + beanName);
            ((MyBean) bean).setName("Modified Name Before Initialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean) {
            System.out.println("bean初始化后: " + beanName);
            /*Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(bean.getClass());
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    System.out.println("Before method: " + method.getName());
                    Object result = proxy.invokeSuper(obj, args);
                    System.out.println("After method: " + method.getName());
                    return result;
                }
            });
            return enhancer.create();*/
        }
        return bean;
    }
}
