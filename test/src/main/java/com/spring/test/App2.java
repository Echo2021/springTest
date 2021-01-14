package com.spring.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.provider.FXNewsProvider;

/**
 * @describe spring 加载 Properties 配置 或xml 配置
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
		
		
		//注解方式导入
		ApplicationContext ctx = new ClassPathXmlApplicationContext("配置文件路径");
		
		FXNewsProvider newsProvider2 = (FXNewsProvider)container.getBean("FXNewsProvider");
		
		/*
		 * <?xml version="1.0" encoding="UTF-8"?> <beans
		 * xmlns="http://www.springframework.org/schema/beans" ➥
		 * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" ➥
		 * xmlns:context="http://www.springframework.org/schema/context" ➥
		 * xmlns:tx="http://www.springframework.org/schema/tx" ➥
		 * xsi:schemaLocation="http://www.springframework.org/schema/beans ➥
		 * http://www.springframework.org/schema/beans/spring-beans-2.5.xsd ➥
		 * http://www.springframework.org/schema/context ➥
		 * http://www.springframework.org/schema/context/spring-context-2.5.xsd ➥
		 * http://www.springframework.org/schema/tx ➥
		 * http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">
		 * 
		 * 扫描指定包 下 @Component 的类，加入容器管理
		 * <context:component-scan base-package="cn.spring21.project.base.package"/>
		 * 
		 * 
		 * </beans>
		 */
		
	}
	
	public static BeanFactory bindViaProperiesFile(BeanDefinitionRegistry registry) {
		
		//PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(registry);
		
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		
		reader.loadBeanDefinitions("classpath:../../binding-config.properties");
		
		return (BeanFactory)registry;
	}
}
