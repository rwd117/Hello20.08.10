
public class statictest 
{
	public static void main(String[] args)
	{
		myclass[] mc=new myclass[10];
	
			for(int i=0;i<10;i++) 
		{
				mc[i]=new myclass();
				System.out.println(mc[0].getobjectnum());
		}
			System.out.println(myclass.getobjectnum());
	}
}
class myclass
{
	static int object_num=0;
	
	public myclass() 
	{
		object_num++;
	}
	
	public static int getobjectnum() 
	{
		return object_num;
	}
}