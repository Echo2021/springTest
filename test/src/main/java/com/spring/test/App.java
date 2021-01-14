package com.spring.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
    	
    	ApplicationContext container = new FileSystemXmlApplicationContext("config.xml");
    	
    	FXNewsProvider newsProvider = (FXNewsProvider)container.getBean("djNewsProvider"); 
    	
 
    		
    	
    }
    
  
}
