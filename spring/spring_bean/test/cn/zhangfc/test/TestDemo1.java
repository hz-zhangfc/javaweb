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
		 * ApplicationContext 有点像jdbc的驱动加载
		 * 需要把配置文件加载进来，并安装配置文件装配好整个spring容器
		 * 
		 * 路劲问题：ClassPathXmlApplicationContext 类路径加载，不明白看看testPath方法
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
		//sop(TestDemo1.class.getClassLoader().getResource("/").getPath()); 会报错
		/**
		 * /E:/gitrepository/servlet/spring/spring_bean/bin/cn/zhangfc/test/
			/E:/gitrepository/servlet/spring/spring_bean/bin/
			/E:/gitrepository/servlet/spring/spring_bean/bin/
			 * 再在这路劲后面填充文件路径
		 */
	}
}
