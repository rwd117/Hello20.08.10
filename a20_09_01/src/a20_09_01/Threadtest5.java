package a20_09_01;

import java.awt.EventQueue;

class mythread5 extends Thread{
	int num=0;
	String name;
	public mythread5() {}
	public mythread5(String name) {this.name=name;}
	public void run() {
		while(true) {
			System.out.println(name+":"+(num++));
			
		}
	}
}

public class Threadtest5 {

	public static void main(String[] args) {
		mythread5 my5=new mythread5("��");
		mythread5 my6=new mythread5("��");
		EventQueue.invokeLater(my5);//�ϳ��� ����.
		my5.start();
		my6.start();
		
	}

}
