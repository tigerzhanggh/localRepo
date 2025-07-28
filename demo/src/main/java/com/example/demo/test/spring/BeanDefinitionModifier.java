package com.example.demo.test.spring;

import com.example.demo.test.bean.MyBean;
import com.example.demo.test.bean.MyBean2;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanDefinitionModifier implements BeanDefinitionRegistryPostProcessor {

    /*
     * 优先 BeanFactoryPostProcessor 执行
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor 调用 ");
        System.out.println("在 postProcessBeanDefinitionRegistry 中修改现有的 BeanDefinition");

        //实现BeanDefinitionRegistryPostProcessor这个接口，也可以重写其父类。
        // 但实现了BeanDefinitionRegistryPostProcessor的postProcessBeanFactory方法会先执行，
        // 再执行实现了BeanFactoryPostProcessor的postProcessBeanFactory。具体看调用顺序图使用场景
        if (registry.containsBeanDefinition("myBean")) {
            BeanDefinition beanDefinition = registry.getBeanDefinition("myBean");
            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
            propertyValues.add("age", 26);
        }
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyBean.class);
        beanDefinitionBuilder.getBeanDefinition().getPropertyValues().addPropertyValue("name","myConditionalBean");
        registry.registerBeanDefinition("myBean4",beanDefinitionBuilder.getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // 此方法可以留空或用于进一步处理
    }
}