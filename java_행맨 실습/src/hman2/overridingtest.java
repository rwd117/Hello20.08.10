package hman2;

public class overridingtest 
{
	public static void main(String[] args)
	{
		dog yourdog=new dog("¶×",4);
		
		yourdog.bark();
		yourdog.bite("¿ìÃ¼ºÎ");
		
		snoopy mydog=new snoopy();
		
		mydog.bark();
		mydog.bite("¶×",9);
	}
}
