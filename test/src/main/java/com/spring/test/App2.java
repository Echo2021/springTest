package com.spring.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

import com.spring.provider.FXNewsProvider;

/**
 * @describe spring 加载 Properties 配置
 * @author User 
 * @date 2021年1月14日 上午11:59:38
 * @version 1.0
 * @param (参数)
 * @return 
 */
public class App2 {

	public static void main(String[] args) {
		
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();  
		
		BeanFactory container = (BeanFactory)bindViaProperiesFile(beanRegistry);
		
		FXNewsProvider newsProvider = (FXNewsProvider)container.getBean("djNewsProvider");
		
	}
	
	public static BeanFactory bindViaProperiesFile(BeanDefinitionRegistry registry) {
		
		PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(registry);
		
		reader.loadBeanDefinitions("classpath:../../binding-config.properties");
		
		return (BeanFactory)registry;
	}
}
