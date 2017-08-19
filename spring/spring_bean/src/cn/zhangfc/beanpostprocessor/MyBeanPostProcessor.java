package cn.zhangfc.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	//很像过滤器，有木有
	
	
	//该方法在 init 方法之后被调用
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		if(arg1.equals("zs"))
		{
			System.out.println("postProcessAfterInitialization..." + arg0 + "," + arg1);
			Person p = (Person) arg0;
			p.setComment("他是一个帅比");
		}
		return arg0;
	}
	//该方法在 init 方法之前被调用
		//可以操作返回的对象来决定最终返回给 getBean 方法的对象是哪一个, 属性值是什么
	//arg1时xml中配置的id属性，argo是要返回得到bean
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		if(arg1.equals("zs")){
			System.out.println("postProcessBeforeInitialization..." + arg0 + "," + arg1);
		}
		return arg0;
	}

}
