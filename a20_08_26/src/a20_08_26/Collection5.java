package a20_08_26;

import java.util.Hashtable;
import java.util.Set;

//map key�� value�� ����->>���� ���� x, �׳� ���� /Ű���� �ߺ��Ǹ� �ϳ��� �������� ��
//�� �߿��� hashtable Ŭ���� Ȱ��.
public class Collection5 
{
	
	public static void main(String[]args) {
		
		Hashtable<String,String> ht=new Hashtable<String,String>();
		ht.put("��", "��,xxx-xxxx");
		ht.put("��", "��,xxx-xxxx");
		ht.put("��", "��,xxx-xxxx");
		ht.put("��", "��,xxx-xxxx");
		ht.put("��", "��,xxx-xxxx");
		
		Set<String> n=ht.keySet();
		for(String it:n) {
			System.out.println(it+":"+ht.get(it));
		}
		
		System.out.println("------------");
		System.out.println(ht.get("��"));
		
	}
}
