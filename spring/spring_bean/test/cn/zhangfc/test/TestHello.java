package cn.zhangfc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zhangfc.hello.HelloSpring;
import cn.zhangfc.hello.Person;

public class TestHello extends Test0 {
	@Test
	public void testHello()
	{
		/**
		 * ApplicationContext �е���jdbc����������
		 * ��Ҫ�������ļ����ؽ���������װ�����ļ�װ�������spring����
		 * 
		 * ·�����⣺ClassPathXmlApplicationContext ��·�����أ������׿���testPath����
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("/cn/zhangfc/hello/hello.xml");
		HelloSpring hs = (HelloSpring) context.getBean("hellospring");
		sop(hs.getName());
	}
	
	@Test
	public void testPath()
	{
		sop(TestHello.class.getResource("").getPath());
		sop(TestHello.class.getResource("/").getPath());
		sop(TestHello.class.getClassLoader().getResource("").getPath());
		//sop(TestDemo1.class.getClassLoader().getResource("/").getPath()); �ᱨ��
		/**
		 * /E:/gitrepository/servlet/spring/spring_bean/bin/cn/zhangfc/test/
			/E:/gitrepository/servlet/spring/spring_bean/bin/
			/E:/gitrepository/servlet/spring/spring_bean/bin/
			 * ������·����������ļ�·��
		 */
	}
	
	/**
	 * hello.xml�е�2��3  ����ע��Ͳ���ע��
	 */
	@Test
	public void test2()
	{
		Person p1 = (Person) super.context.getBean("person1");
		Person p2 = (Person) super.context.getBean("person2");
		sop(p1);
		sop(p2);
	}
	
	/**
	 * 4
	 */
	@Test
	public void test3()
	{
		Person p1 = (Person) super.context.getBean("person3");
		Person p2 = (Person) super.context.getBean("person4");
		Person p3 = (Person) super.context.getBean("person5");
		sop(p1);
		sop(p2);
		sop(p3);
	}
}
