package java_실습_Kimjw;

public class test26 {
	
	public static void main(String[]args)
	{
		int i,j;
		
		i=10;
		OUT_WHILE:while(true)//브레이크 된 시점에서 이쪽으로 온다 라는 것을 명시
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
