package java_½Ç½À_Kimjw;

public class test11 
{
	public static void main(String[] args) 
	{
		int hour=13;
		int min=30;
		int sec=25;
		
		String ampm;
		ampm=(hour>=12)?"PM":"AM";
		hour=(hour>=12)?(hour-12):hour;
		
		System.out.println(ampm+":"+hour+":"+min+":"+sec);
	}
}
