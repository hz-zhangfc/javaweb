package test;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class Test0 {
	private ApplicationContext context;
	public Test0(String path)
	{
		context = new ClassPathXmlApplicationContext(path);
	}
	public Object getBean(String beanName)
	{
		return context.getBean(beanName);
	}
	public void sop(Object obj)
	{
		System.out.println(obj);
	}
}
