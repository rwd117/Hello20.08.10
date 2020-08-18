
public class pointtest 
{
	public static void main(String[] args) 
	{
		Point p=new Point();
		p.x=10;
		p.y=20;
		p.printXY();
	}
}

class Point
{
	int x;
	int y;
	public void printXY() 
	{
		System.out.println(x+","+y);
	}
}