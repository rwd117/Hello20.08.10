package hman2;

public class animal 
{
	String name;
	int age;
	
	public animal() 
	{
		this("동물",0);
	}
	
	public animal(String name, int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public void print() 
	{
		System.out.println("이름"+name);
		System.out.println("나이"+age);
	}
}
