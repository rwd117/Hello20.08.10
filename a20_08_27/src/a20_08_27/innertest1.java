package a20_08_27;

class outer{
	int outdata=100;
	public void show() {
		System.out.println("-------");
	}
	
	class Inner{
		int indata=200;
		public void print() {
			System.out.println(outdata);
			show();
		}
	}
}


public class innertest1 {

	public static void main(String[] args) {
		outer out=new outer();
		outer.Inner in=out.new Inner();
		in.print();
		
		
	}

}
