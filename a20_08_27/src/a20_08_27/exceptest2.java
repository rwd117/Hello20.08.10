package a20_08_27;

public class exceptest2 {

	public static void main(String[] args) {
		String name=null;
		int a=10;
		int b=0;
		int c=0;
		try {
			c=a/b;
			name=name.toString()+"����";
		}catch(ArithmeticException e) {
			System.out.println("���"+e);
		}catch(NullPointerException e) {
			System.out.println("��"+e);
		}catch(Exception e) {
			System.out.println("����"+e);	
		}
		finally {
			System.out.println("��~��");
		}
		System.out.println(name);
		System.out.println(c);
	}
}
