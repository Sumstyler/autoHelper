package com.it.run;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.context.support.GenteratorProcessor;

import freemarker.template.TemplateException;

public class Runner {

	public static void main(String[] args) throws IOException, TemplateException {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");  
		//获取配置文件 
		GenteratorProcessor  genteratorProcessor= (GenteratorProcessor)context.getBean("genteratorProcessor");
		genteratorProcessor.generatorFile();
	}

}