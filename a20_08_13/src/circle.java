
public class circle extends Shape {

	private int r;
	
	public void area() {
		res=r*r*Math.PI;
	}

	
	public circle() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getR() {
		return r;
	}


	public circle(int r) {
		super();
		this.r = r;
	}


	public void setR(int r) {
		this.r = r;
	}


	public void draw() {
		// TODO Auto-generated method stub
		
	}
	public void show() 
	{
		System.out.println(res);
	}
}
