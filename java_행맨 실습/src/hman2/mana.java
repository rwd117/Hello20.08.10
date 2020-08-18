package hman2;

public class mana extends emp 
{
	String department;
	public mana(String n, int s, String d) {
		super(n, s);
		department=d;
	}
	
	public void getinformation() 
	{
		System.out.println(name+","+department+","+salary);
	}
	
	
}
