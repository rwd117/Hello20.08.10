package a20_08_26;

import java.util.ArrayList;
import java.util.Collections;

public class collection1 {

	public static void show(ArrayList<Integer> a) {
		for(int num : a) {
			System.out.println(num);
		}
	}
	public static void main(String[] args) {
			ArrayList<Integer> a=new ArrayList<Integer>();
	
			
			a.add(10);
			a.add(20);
			a.add(30);
			a.add(20);
			a.add(20);
			a.add(20);
			a.add(20);
			
			a.remove(0);
			a.remove(new Integer(20));//20이라는 정수를 제거,처음에 해당하는 정수만 삭제
			a.set(0, 100);
			a.set(1, 200);
			show(a);
			
			System.out.println("--------------------");
			Collections.sort(a); //오름차순 배열
			show(a);
			
	
	}
			
	}


