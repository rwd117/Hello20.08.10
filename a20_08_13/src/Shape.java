
public abstract class Shape 
{
	protected double res;
	public void show() 
	{
		System.out.println(res);
	}
	public abstract void area();
	public abstract void draw();//추상화는 {} 가 아닌 ;로
}
