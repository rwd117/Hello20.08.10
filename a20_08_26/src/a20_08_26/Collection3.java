package a20_08_26;

import java.util.Stack;


//stack : LIFO ���Լ���  push�� add pop�� ������ ���� �ϳ��� ���(�Ǹ������� �Է��Ѱ�)
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
		name.addElement("��");
		name.push("��");
		name.push("��");
		show(name);
		
	}
}
