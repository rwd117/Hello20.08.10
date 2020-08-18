import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reverseString {

	public static void main(String[] args)throws IOException
	{
		System.out.println("거꾸로 ㄱ");
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		String str=in.readLine();
		
		StringBuffer sb=new StringBuffer(str);
		System.out.println(sb.reverse());//뒤집은거 출력
	}
}
