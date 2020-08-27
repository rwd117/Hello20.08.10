package a20_08_27;

public class exceptest3 {
//한번씩 실행을 멈추고싶을때 사용함.
	public static void main(String[] args) {
		try{
		Exception e=new Exception("?");
		throw e;
		
		}catch(Exception e) {
			System.out.println("끝"+e);
		}
		
	}
}
