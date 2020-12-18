package Set;

import java.util.ArrayList;
import java.util.Arrays;

import Db.CardNumDb;

public class AllNum {

	public static ArrayList<String> CardNum(ArrayList<String> cardNum) {
		String card[]={ "카드 번호를 골라주세요", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20" };
		
		ArrayList<String> Card= new ArrayList<String>(Arrays.asList(card)); 
		
		//이 배열을 데이터베이스에서 받아서 하나하나 체크해서 사용 중인경우는 배열에서 제외시켜서 배열을 재배열
		System.out.println("card는"+Card);
		
		ArrayList<String> noCard=  CardNumDb.Setting(card);
		
		
		System.out.println("nocard는"+noCard);

		
		for(int i=0;i<Card.size();i++) {
			for(int j=0;j<noCard.size();j++) {
				if(Card.get(i).equals(noCard.get(j))) {
					Card.remove(i);
				}
			}
		}
		
		
		return Card ;
	}
	
	public static ArrayList<String> PCNum(ArrayList<String> a) {
		String pc[]= {"좌석을 골라주세요","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
				"21","22","23","24","25","26","27","28","29","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48"};
		
		ArrayList<String> PC= new ArrayList<String>(Arrays.asList(pc)); 
		System.out.println("pc는"+PC);
		
		ArrayList<String> noPC=CardNumDb.Setting(pc);
		System.out.println("nopc는"+noPC);
		
		for(int i=0;i<PC.size();i++) {
			for(int j=0;j<noPC.size();j++) {
				if(PC.get(i).equals(noPC.get(j))) {
					PC.remove(i);
				}
			}
		}
		
		return PC;
	}
	
	
	
	
}
