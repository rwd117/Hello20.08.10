package hman2;

public class snoopy extends dog
{
	public snoopy() 
	{
		super("스누피",3);
	}
	public void bite (String name,int age) 
	{
		System.out.println(dog_name+"가 문"+name+"은"+age+"살");
	}

	public void bark() 
	{
		System.out.println("ㅎㅇ"+dog_name+"입니다");
	}
}
