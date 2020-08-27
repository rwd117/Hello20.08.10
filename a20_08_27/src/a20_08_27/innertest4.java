package a20_08_27;

class outer1{
	int outdata=100;
	public Object method() {
		final int data=200;
		class Inner{
			public String toString() {
				return "°á°ú="+(outdata+data);
			}
		}
		return new Inner();
	}
}

public class innertest4 
{
	public static void main(String[] args) {
		outer1 out=new outer1();
		Object obj=out.method();
		System.out.println(obj.toString());
	}
}
