package hman2;

public class snoopy extends dog
{
	public snoopy() 
	{
		super("������",3);
	}
	public void bite (String name,int age) 
	{
		System.out.println(dog_name+"�� ��"+name+"��"+age+"��");
	}

	public void bark() 
	{
		System.out.println("����"+dog_name+"�Դϴ�");
	}
}
