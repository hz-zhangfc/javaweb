package cn.zhangfc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public  abstract class Test0 {
	public ApplicationContext context;
	public Test0()
	{
		context = new ClassPathXmlApplicationContext("/cn/zhangfc/hello/hello.xml");
	}
	public Test0(String path)
	{
		context = new ClassPathXmlApplicationContext(path);
	}
	public void sop(Object obj)
	{
		System.out.println(obj);
	}
	
	/**
	 * @param beanName beanµÄÃû³Æ
	 * @return  context.getBean(beanName);
	 */
	public Object get(String beanName)
	{
		return context.getBean(beanName);
	}
}
