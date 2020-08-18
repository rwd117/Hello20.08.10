package a20_08_18;

public class rectangle implements shape {

	private int w;
	private int h;
	private int res;
	
	public rectangle() {}
	public rectangle(int w, int h) {this.w=w; this.h=h;}
	
	
	@Override
	public void area() {
		res=w*h;
	}

	@Override
	public void show() {
		System.out.println(res);
	}

}
