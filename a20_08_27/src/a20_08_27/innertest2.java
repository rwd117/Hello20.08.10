package a20_08_27;

class circle{
	private int r;
	private double res;
	public circle() {}
	public circle(int r) {this.r=r;}
	public void cal() {
		res=r*r*Math.PI;
	}
	public void show() {
		System.out.println(res);
	}
	
	public static circle instance=new circle();//자기 자신을 new 하는것
	
	public static circle getInstance() {
		return instance;
	}
}

class rectangle{
	int w,h,res;
	public void cal() {
		res=w*h;
	}
	public void show() {
		System.out.println(res);
	}
	public static rectangle instance=new rectangle();
	
	public static rectangle getInstance() {
		return instance;
	}
}

public class innertest2 
{
	public static void main(String[] args) {
		circle c=new circle();
		c.cal();
		c.show();
		circle c1=circle.getInstance();
		c1.cal();
		c1.show();
		
		Object c2=new circle() {
			
		};
		
		rectangle r=rectangle.getInstance();
		r.cal();
		r.show();
	}
}
