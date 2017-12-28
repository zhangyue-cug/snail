package org.snail.study;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * <pre>测试</pre>
 * 
 * @author zhangyue
 *
 */
public class HelloTest {
	
	ApplicationContext context = null;
	
	@Before
	public void before() {
		System.out.println("============= start ==============");
		context = new ClassPathXmlApplicationContext("application-bean.xml");
	}
	
	@After
	public void after() {
		context = null;
		System.out.println("============= closed ==============");
	}
	
	@Test
	public void testHello() {
		System.out.println("Application Name: " + context.getEnvironment());
		Hello hello = context.getBean("hello", Hello.class);
		hello.sayHello();
	}
	
	public static void main(String[] args) {
//		Object[] o = {1, 3, 5};
//		Object[] o1 = Arrays.copyOf(o, 6);
//		o1[5] = 5;
//		System.out.println(Arrays.asList(o));
//		System.out.println(o.length);
//		System.out.println("======");
//		System.out.println(o1);
//		System.out.println(o1.length);
		
		/*for(int i = 0; i < o1.length; i++) {
			System.out.println(o1[i]);
			System.out.println("---");
		}
		
		System.out.println("==================");
		List<String> list = new ArrayList<>();
		list.add("1");
		System.out.println(list);
		
		list.add(1, "2");
		System.out.println("=============");
		System.out.println(list);*/
		
//		String[] words = { "hello", "world" };
//		Arrays.asList(words).stream().map(word -> word.split("")).forEach(v -> System.out.println(Arrays.asList(v)));
//		List<String> collect = Arrays.asList(words).stream().map(word -> word.split("")).flatMap(Arrays::stream)
//				.distinct().collect(Collectors.toList());
//		System.out.println(collect);
		
		ClassPathResource resource = new ClassPathResource("application-bean.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		Hello hello = factory.getBean("hello", Hello.class);
		hello.sayHello();
		
	}
	
}