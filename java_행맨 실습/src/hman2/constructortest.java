package hman2;

public class constructortest {

	public static void main(String[] args) {
		animal am=new animal();
		am.print();
		
		human hm=new human();
		hm.print();
		
		boy by=new boy();
		by.print();
		
		System.out.println();
		
		animal tiger=new animal("∞≈∫œ¿Ã",8);
		tiger.print();
		
		human mary=new human("±Ë¡§æ∆",20);
		mary.print();
		
		boy smin=new boy("πÈΩ¬πŒ",14);
		smin.print();
	}

}
