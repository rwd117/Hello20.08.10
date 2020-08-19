package java½Ç½À_applet;

public class Intetface implements height
{
	private double cm=0;
	
	public Intetface(double cm)
	{
		this.cm=cm;
	}
	public double getInch() 
	{
		return cm/inch;
	}
	
	public double getCM() {
		return cm;
	}
	
	public double getMeter() 
	{
		return cm/100;
	}
	
	public static void main(String[] args) 
	{
		Intetface myheight=new Intetface(183);
		
		System.out.println(myheight.getCM());
		System.out.println(myheight.getInch());
		System.out.println(myheight.getMeter());
		
	}
}
