package cn.zhangfc.ascepj;

import org.springframework.stereotype.Component;

@Component
public class CalcultorImpl  implements Calcultor{

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stu
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double div(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}

}
