
public class call 
{
	public call() {	}
	public call(Shape temp) 
	{	if(temp instanceof circle)
		{
			circle c=(circle) temp;
			c.setR(10);
			c.area();
			c.show();
			
		}else if(temp instanceof rectangle)
		{
			rectangle r=(rectangle) temp;
			r.setH(6);
			r.setW(5);
			r.area();
			r.show();
		}else if(temp instanceof triangle)
		{
			triangle t=(triangle) temp;
			t.setH(6);
			t.setW(5);
			t.area();
			t.show();
		}
		
	}
	
}
