package hman2;

class a
{
	public int a;
	
	public void method_A() 
	{
		a=100;
	}
}
class b
{
	public int b;
	
	public void method_B() 
	{
		b=200;
	}
}
class c
{
	public int c;
	
	public void method_C() 
	{
		c=300;
	}
}
class d extends a
{
	public void method_D() 
	{
		method_A();
	}
}
class e extends b
{
	public void method_E() 
	{
		method_B();
	}
}
class f extends c
{
	
	public void method_F() 
	{
		method_C();
	}

	
}

public class abcdef {

}
