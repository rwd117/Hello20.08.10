package a20_08_18;

public class intermain {
	
	public static void call(shape s, int x) 
	{
		if(s instanceof circle) 
		{circle cr=(circle) s;
			cr.area();
			cr.show();
		}
		else if(s instanceof triangle) 
		{
			triangle tr=(triangle) s;
			tr.area();
			tr.show();
		}
		else 
		{
			rectangle rr=(rectangle) s;
			rr.area();
			rr.show();
		}
		switch(x) {
		case 1: System.out.println("r"); break;
		case 2: System.out.println("b"); break;
		case 3: System.out.println("g"); break;
		}
	}
	
	
	public static void main(String[] args) {
		circle c=new circle(5);
		call(c, shape.r);
		
		triangle t= new triangle(5,6);
		call(t, shape.b);
		
		rectangle r=new rectangle(5,6);
		call(r, shape.g);
	}

}
