package com.example.demo.test.spring;

import com.example.demo.test.bean.MyBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class CustomInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /*
    在Bean实例化之前调用，如果返回null，一切按照正常顺序执行；
    如果返回的是一个实例的对象，那么postProcessAfterInstantiation()会执行，其他的扩展点将不再触发
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass == MyBean.class) {
            System.out.println("实例化之前 Bean: " + beanName);
            /*Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    System.out.println("调用方法: " + method.getName());
                    return proxy.invokeSuper(obj, args);
                }
            });
            return enhancer.create();*/
        }
        return null;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean == MyBean.class) {
            System.out.println("初始化之后的 Bean: " + beanName);
        }
        return bean;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean) {
            System.out.println("实例化之后控制依赖注入: " + beanName);
            return false; // 不进行默认的依赖注入
        }
        if (bean == MyBean.class) {
            System.out.println("InstantiationAwareBeanPostProcessor postProcessAfterInstantiation方法 " +beanName);
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean) {
            System.out.println("设置属性值之前: " + beanName);
            // 修改属性值的逻辑
        }
        return pvs;
    }
}