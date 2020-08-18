
public class constructor {
	public static void main(String[] args)
	{
		clock c= new clock(10,55,16);
		c.printtime();
	}
}
class clock
{
	int hour;
	int min;
	int sec;
	public clock(int h,int m, int s)
	{
		hour=h;
		min=m;
		sec=s;
	}
	
	public void printtime() 
	{
		System.out.println(hour+":"+min+":"+sec);
	}
}
