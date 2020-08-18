package a20_08_18;

public class circle implements shape {
	
	private int r;
	private double res;
	
	public circle() {}
	public circle(int r) {this.r=r;}
	
	@Override
	public void area() {
		res=r*r*Math.PI;
		
	}

	@Override
	public void show() {
		System.out.println(res);
	}

}
