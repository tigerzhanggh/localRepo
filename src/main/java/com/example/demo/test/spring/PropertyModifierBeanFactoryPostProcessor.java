package com.example.demo.test.spring;

import com.example.demo.test.bean.MyBean;
import com.example.demo.test.bean.MyBean2;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;


/**
 * 这个接口是beanFactory的扩展接口，调用时机在spring在读取beanDefinition信息之后，实例化bean之前。
 * 虽然此时不能再注册beanDefinition，但是可以趁着bean没有实例化，可以修改 Spring 容器启动时修改其内部的 BeanDefinition。
 * 通过实现 BeanFactoryPostProcessor 接口，开发者可以在 Bean 实例化之前修改 Bean 的定义元数据，
 * 例如Scope、依赖查找方式、初始化方法、修改属性值、添加额外的元数据等，进而影响初始化行为。
 */
@Component
public class PropertyModifierBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("实例化bean之前调用BeanFactoryPostProcessor");
        //修改bean属性
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("myBean");
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue("name", "newValue3");
        //注册bean
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyBean2.class);
        beanDefinitionBuilder.getBeanDefinition().getPropertyValues().addPropertyValue("name2","myConditionalBean");
        DefaultListableBeanFactory beanFactory1 = (DefaultListableBeanFactory) beanFactory;
        beanFactory1.registerBeanDefinition("myConditionalBean", beanDefinitionBuilder.getBeanDefinition());
    }
}