package cn.zhangfc.beanlife;

public class Student {
	private String name;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("�ҵ���setName��");
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
		System.out.println("���ǿյĹ��캯��");
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public void imInit()
	{
		System.out.println("���ǳ�ʼ������");
	}
	
	public void imDestroy()
	{
		System.out.println("�������١���");
	}
}
