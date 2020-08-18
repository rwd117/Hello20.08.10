package hman2;

public class emp 
{
	String name;
	int salary;
	
	public emp(String n,int s)
	{
		name=n;
		salary=s;
	}
	
	public void getinformation() 
	{
		System.out.println(name+","+salary);
	}
}
