package com.spring.test;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import com.spring.provider.FXNewsProvider;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//BeanFactory container = new XmlBeanFactory(new ClassPathResource("配置文件路径"));
    	
    	//
    	//ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");
    	
    	//ApplicationContext container = new FileSystemXmlApplicationContext("config.xml");
    	
    	//FXNewsProvider newsProvider = (FXNewsProvider)container.getBean("djNewsProvider"); 
    	
    	DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
    	
    	BeanFactory container = (BeanFactory)bindViaCode(beanRegistry);
    	
    	FXNewsProvider newsProvider = (FXNewsProvider)container.getBean("djNewsProvider"); 
    	
    	//newsProvider.get
   
    }
    
    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {
    	
    	AbstractBeanDefinition newsProvider= new RootBeanDefinition(FXNewsProvider.class);
    	
    	AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class);
    	
    	AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class);
    	
    	//注册
    	registry.registerBeanDefinition("djNewsProvider", newsProvider);
    	registry.registerBeanDefinition("djListener", newsListener);
    	registry.registerBeanDefinition("djPersister", newsPersister);
    	
    	
    	//指定依赖，注入
    	
    	//1、构造方法注入
    	ConstructorArgumentValues argValues = new ConstructorArgumentValues();
    	
    	argValues.addIndexedArgumentValue(0, newsListener);
    	
    	argValues.addIndexedArgumentValue(1, newsPersister);
    	
    	newsProvider.setConstructorArgumentValues(argValues);
    	
    	//2、setter 方法注入
    	MutablePropertyValues propertyValues = new MutablePropertyValues();
    	
    	propertyValues.addPropertyValue(new PropertyValue("newsListener",newsListener));
    	
    	propertyValues.addPropertyValue(new PropertyValue("newPersistener",newsPersister));
    	
    	newsProvider.setPropertyValues(propertyValues);
    	
    	return (BeanFactory)registry;
    
    }
    
  
}
