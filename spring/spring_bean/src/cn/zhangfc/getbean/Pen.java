package cn.zhangfc.getbean;

public class Pen {
	public Pen() {
		super();
	}
	private String name;
	private String color;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Pen(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Pen [name=" + name + ", color=" + color + "]";
	}
	
}
