package java�ǽ�_applet;

import java.applet.*;

public class CanvasTest extends Applet
{
	Mycanvas myCanvas;
	public void init() {
		myCanvas = new Mycanvas();
		add(myCanvas);
	}
}
