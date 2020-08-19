package java½Ç½À_applet;

import java.applet.*;
import java.awt.*;

public class parametertest extends Applet 
{
	String args;
	
	public void init() 
	{
		args=getParameter("APPLET_PARAMETER");
		if(args==null) 
		{
			args="NO APPLET_PARAMETER";
		}
	}
	
	public void paint(Graphics g)
	{
		g.drawString(args, 50, 100);
	}
}
