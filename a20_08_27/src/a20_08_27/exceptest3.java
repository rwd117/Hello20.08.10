package a20_08_27;

public class exceptest3 {
//�ѹ��� ������ ���߰������ �����.
	public static void main(String[] args) {
		try{
		Exception e=new Exception("?");
		throw e;
		
		}catch(Exception e) {
			System.out.println("��"+e);
		}
		
	}
}
