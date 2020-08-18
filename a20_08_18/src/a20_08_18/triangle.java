package a20_08_18;

public class triangle implements shape {
	
	
	private int w;
	private int h;
	private double res;
	
	public triangle() {}
	public triangle(int w, int h) {this.w=w;
	this.h=h;}
	
	@Override
	public void area() {
		res=(h*w)/2.0;
	}

	@Override
	public void show() {
		System.out.println(res);
	}

}
