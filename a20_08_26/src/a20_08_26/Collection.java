package a20_08_26;

import java.util.Vector;


	
//vector
public class Collection {
		public static void show(Vector<String> vec) {
			System.out.println("--------------");
			for(String str : vec) {
				System.out.println(str);
			}
		}
		public static void main(String[] args) {
			Vector<String> vec=new Vector<String>(2,2);//�⺻���� 100�� �Ҵ�, �� ä������ 10�� ���� 
			vec.add("��");
			System.out.print(vec.size()+"\t");
			System.out.println(vec.capacity());//�� �뷮 
			vec.add("��");
			System.out.print(vec.size()+"\t");
			System.out.println(vec.capacity());
			vec.add("��");
			System.out.print(vec.size()+"\t");
			System.out.println(vec.capacity());
			vec.add("��");
			System.out.print(vec.size()+"\t");
			System.out.println(vec.capacity());
			
			vec.addElement("��");
			show(vec);
			
			vec.remove(0);//0��°
			vec.removeElement("��");//�ش��ϴ� �迭�� ����
			show(vec);
		}

}
