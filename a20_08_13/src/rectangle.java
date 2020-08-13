
public class rectangle extends Shape {

	private int w,h;
	
	public void area() {
		res=w*h;
	}
	
	public rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public rectangle(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void draw() {

	}
	public void show() 
	{
		System.out.println(res);
	}

	
}
