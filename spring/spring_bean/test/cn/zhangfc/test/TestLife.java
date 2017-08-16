package cn.zhangfc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import cn.zhangfc.beanlife.Student;

public class TestLife extends Test0 {
	public TestLife()
	{
		super("/cn/zhangfc/beanlife/beanLife.xml");
	}
	@Test
	public void test()
	{
		Student s1 = (Student) get("student1");
		sop(s1);
	}
	
	@Test
	public void test2()
	{
		GenericApplicationContext cc= new GenericApplicationContext(super.context);
		Student s1 = (Student) cc.getBean("student1");
		cc.close();
	}
}
