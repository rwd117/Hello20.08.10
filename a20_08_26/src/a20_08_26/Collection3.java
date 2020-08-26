package a20_08_26;

import java.util.Stack;


//stack : LIFO 후입선출  push가 add pop는 위에서 부터 하나씩 출력(맨마지막에 입력한거)
public class Collection3 {
	public static void show(Stack<String> name) {
		System.out.println("--------------");
		while(!name.isEmpty()) {
			System.out.println(name.pop());
		}
	}
	
	
	public static void main(String[] args) {
		Stack<String> name=new Stack<String>(); 
		Stack<Integer> it=new Stack<Integer>();
		name.addElement("ㄱ");
		name.push("ㄴ");
		name.push("ㄷ");
		show(name);
		
	}
}
