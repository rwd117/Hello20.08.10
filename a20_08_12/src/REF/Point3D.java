package REF;

public class Point3D extends Point 
{
	private int z;
	public void show() 
	{	super.show();
		System.out.println(z);
	}
	public Point3D() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Point3D(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	public Point3D(int z) {
		super();
		this.z = z;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
	
}
