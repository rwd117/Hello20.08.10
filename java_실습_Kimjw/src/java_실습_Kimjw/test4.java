package java_실습_Kimjw;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class test4 {
 
	public static void main(String[] args) 
	{
		Date today=new Date();
		SimpleDateFormat dateForm=new SimpleDateFormat("yyyy년 MM월 dd일의");
		System.out.println(dateForm.format(today));
		
		Random r=new Random();
		int randomNum=Math.abs(r.nextInt()%100)+1;
		System.out.println(randomNum+"%");

	}

}
