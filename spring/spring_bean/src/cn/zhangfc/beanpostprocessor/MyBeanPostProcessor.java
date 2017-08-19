package cn.zhangfc.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	//�������������ľ��
	
	
	//�÷����� init ����֮�󱻵���
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		if(arg1.equals("zs"))
		{
			System.out.println("postProcessAfterInitialization..." + arg0 + "," + arg1);
			Person p = (Person) arg0;
			p.setComment("����һ��˧��");
		}
		return arg0;
	}
	//�÷����� init ����֮ǰ������
		//���Բ������صĶ������������շ��ظ� getBean �����Ķ�������һ��, ����ֵ��ʲô
	//arg1ʱxml�����õ�id���ԣ�argo��Ҫ���صõ�bean
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		if(arg1.equals("zs")){
			System.out.println("postProcessBeforeInitialization..." + arg0 + "," + arg1);
		}
		return arg0;
	}

}
