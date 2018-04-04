package com.udp.nb.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @date 2016年9月5日
 */
@Component
public class ServiceUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	private ServiceUtil(){}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		this.applicationContext = applicationContext;
	}

	public static Object getBean(String name){
		
		return applicationContext.getBean(name);
    }
}
