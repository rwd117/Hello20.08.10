package a20_08_26;

import java.util.Hashtable;
import java.util.Set;

//map key와 value로 구성->>순차 구조 x, 그냥 집합 /키값이 중복되면 하나가 지워지는 것
//그 중에서 hashtable 클래스 활용.
public class Collection5 
{
	
	public static void main(String[]args) {
		
		Hashtable<String,String> ht=new Hashtable<String,String>();
		ht.put("ㄱ", "ㅂ,xxx-xxxx");
		ht.put("ㄴ", "ㅈ,xxx-xxxx");
		ht.put("ㄷ", "ㅊ,xxx-xxxx");
		ht.put("ㄹ", "ㅋ,xxx-xxxx");
		ht.put("ㅁ", "ㅌ,xxx-xxxx");
		
		Set<String> n=ht.keySet();
		for(String it:n) {
			System.out.println(it+":"+ht.get(it));
		}
		
		System.out.println("------------");
		System.out.println(ht.get("ㅁ"));
		
	}
}
