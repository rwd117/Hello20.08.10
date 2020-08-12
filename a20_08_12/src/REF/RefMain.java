package REF;

import javax.swing.JFrame;

public class RefMain 
{
	public static void call(Point obj) 
	{	if(obj instanceof Point3D) 
		{
			Point3D p=(Point3D) obj;
			p.setX(10);
			p.setY(10);
			p.setZ(30);
			p.show();
		}
		else 
		{	obj.setX(10);
			obj.setY(10);
			obj.show();
		}
	}
	public static void main(String[] args) 
	{ 
		Point p=new Point3D(); //부모객체에 저장가능(업캐스트)
		call(p);
		
		Point x=new Point();
		call(x);
		
		JFrame frame=new JFrame();
		frame.setVisible(true);
		frame.setTitle("연습");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(300, 300, 500, 500);
	}

}
