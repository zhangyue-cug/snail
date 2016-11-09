package org.snail.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	ApplicationContext context = null;
	
	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("application-bean.xml");
	}
	
	@After
	public void after() {
		
	}
	
	@Test
	public void testHello() {
		Hello hello = context.getBean("hello", Hello.class);
		hello.sayHello();
	}
}
