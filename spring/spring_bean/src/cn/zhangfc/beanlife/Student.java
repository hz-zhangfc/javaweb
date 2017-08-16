package cn.zhangfc.beanlife;

public class Student {
	private String name;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("我调用setName了");
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}
	public Student() {
		super();
		System.out.println("我是空的构造函数");
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public void imInit()
	{
		System.out.println("我是初始化。。");
	}
	
	public void imDestroy()
	{
		System.out.println("我是销毁。。");
	}
}
