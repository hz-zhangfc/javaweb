package cn.zhangfc.getbean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;

public class MyPenBeanFactory  implements FactoryBean<Pen>{

	@Override
	public Pen getObject() throws Exception {
		// TODO Auto-generated method stub
		Pen p = new Pen("factorybeanPen","white");
		return p;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
