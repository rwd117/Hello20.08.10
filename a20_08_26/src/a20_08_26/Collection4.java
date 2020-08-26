package a20_08_26;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

//순차 접근 Iterator
//순차 접근 Enumeration
//vector arraylist linkedlist 에 사용
public class Collection4
{
	
	public static void main(String[]args) {
		Vector<String> n=new Vector<String>(10,10);
		n.addElement("r");
		n.addElement("s");
		n.addElement("e");
		n.addElement("f");
		
		Iterator<String> item=n.iterator(); //하나의 집합으로 만들어 관리.
		while(item.hasNext()) {
			System.out.println(item.next());
		}
		
		System.out.println("---------------------");
		
		Enumeration<String> item2=n.elements();
		while(item2.hasMoreElements()) {
			System.out.println(item2.nextElement());
		}
		
	}
}
