package hman2;

public class animal 
{
	String name;
	int age;
	
	public animal() 
	{
		this("����",0);
	}
	
	public animal(String name, int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public void print() 
	{
		System.out.println("�̸�"+name);
		System.out.println("����"+age);
	}
}
