package java_�ǽ�_Kimjw;

public class test26 {
	
	public static void main(String[]args)
	{
		int i,j;
		
		i=10;
		OUT_WHILE:while(true)//�극��ũ �� �������� �������� �´� ��� ���� ���
		{
			j=0;
			while(true) {
				System.out.print("*");				
			j++;
			if(j>=i) break;
			}
			System.out.println();
			i--;
			if(i<=0)	break OUT_WHILE; 
		}
	}
}
