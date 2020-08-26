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
			Vector<String> vec=new Vector<String>(2,2);//기본으로 100개 할당, 다 채워지면 10씩 증가 
			vec.add("ㄱ");
			System.out.print(vec.size()+"\t");
			System.out.println(vec.capacity());//총 용량 
			vec.add("ㄴ");
			System.out.print(vec.size()+"\t");
			System.out.println(vec.capacity());
			vec.add("ㄷ");
			System.out.print(vec.size()+"\t");
			System.out.println(vec.capacity());
			vec.add("ㄹ");
			System.out.print(vec.size()+"\t");
			System.out.println(vec.capacity());
			
			vec.addElement("ㅁ");
			show(vec);
			
			vec.remove(0);//0번째
			vec.removeElement("ㅁ");//해당하는 배열을 제거
			show(vec);
		}

}
