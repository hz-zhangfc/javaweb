package cn.zhangfc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zhangfc.hello.HelloSpring;

public class TestDemo1 extends Test0 {
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
		sop(TestDemo1.class.getResource("").getPath());
		sop(TestDemo1.class.getResource("/").getPath());
		sop(TestDemo1.class.getClassLoader().getResource("").getPath());
		//sop(TestDemo1.class.getClassLoader().getResource("/").getPath()); �ᱨ��
		/**
		 * /E:/gitrepository/servlet/spring/spring_bean/bin/cn/zhangfc/test/
			/E:/gitrepository/servlet/spring/spring_bean/bin/
			/E:/gitrepository/servlet/spring/spring_bean/bin/
			 * ������·����������ļ�·��
		 */
	}
}
