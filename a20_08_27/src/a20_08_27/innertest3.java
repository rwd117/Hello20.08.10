package a20_08_27;

class triangle{
	private int w,h;
	private double res;
	
	public void cal() {}
	public void show() {
		System.out.println(res);
	}
}

public class innertest3 {
	public static void main(String[] args) {
		triangle t=new triangle() {
			private int w,h;
			private double res;
			
			public void cal() {
				res=w*h/2.+0.5;
			}
			
			public void show() {
				System.out.println(res);
			}
		};
		t.cal();
		t.show();
	}
}
