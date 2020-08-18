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
		System.out.println(dog_name+"¾È ¹³");
	}
	public void bite(String name) 
	{
		System.out.println(dog_name+"°¡"+name+"¸¦ ¹³");
	}
	public void bark() 
	{
		System.out.println("¿Ð¿Ð");
	}

}
