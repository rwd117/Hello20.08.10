package hman2;

public class dog 
{
	String dog_name;
	int dog_age;
	
	public dog(String name, int age) 
	{
		dog_name=name;
		dog_age=age;
	}
	public void bite() 
	{
		System.out.println(dog_name+"�� ��");
	}
	public void bite(String name) 
	{
		System.out.println(dog_name+"��"+name+"�� ��");
	}
	public void bark() 
	{
		System.out.println("�п�");
	}

}
