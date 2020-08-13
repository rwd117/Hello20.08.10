
public class triangle extends Shape {

	private int w,h;
	
	public int getW() {
		return w;
	}
	public triangle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public triangle(int w, int h) {
		super();
		this.w = w;
		this.h = h;
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
	public void area() {
		res=(w*h)/2.0;
	}
	@Override
	public void draw() {

	}
	public void show() 
	{
		System.out.println(res);
	}
}
