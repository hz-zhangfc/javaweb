package cn.zhangfc.ascepj;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * ��������Ϊ����:
 *    1.��IOC��������������bean(@Component)
 *    2.����Ϊ����(@Aspect)
 */
@Aspect
@Component
public class LogginAspect {
	//��������һ��ǰ��֪ͨ
	//@Before("execution(* com.zj.asceptj.*.*(..))")
	//*����һ��ռλ������ʾ�����ַ�����ҿ��Ը�ԭ����д���Ա�һ��
	@Before("execution(* cn.zhangfc.ascepj.Calcultor.add(int,int))")
	//Calcultor�ǽӿڣ��ӿ��Լ�����ʵ���౻����
	public void before(JoinPoint jp)
	{
		//ע�⣬JoinPoint����org.aspectj.lang.JoinPoint��С�ĵ����
        //������
		String methodName = jp.getSignature().getName();
		//��������
		List<Object> args =  Arrays.asList(jp.getArgs());
		System.out.println("������:"+methodName+",and args"+args);
	}
	 @After("execution(* cn.zhangfc.ascepj.*.*(..))")
	    public void afterMethod(JoinPoint joinpoint){
	        //ע�⣬JoinPoint����org.aspectj.lang.JoinPoint��С�ĵ����
	        //������
	        String methodName = joinpoint.getSignature().getName();
	        //��������
	        List<Object> args = Arrays.asList(joinpoint.getArgs());
	        System.out.println("method :"+methodName+" ,and:"+args);
	    }
}
