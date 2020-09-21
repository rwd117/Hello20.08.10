package a20_09_21_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class iptest {

	public static void main(String[] args) 
	{ 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		InetAddress add[], myadd,add1;
		try {
			String url=br.readLine();
			add1=InetAddress.getByName(url);
			add=InetAddress.getAllByName(url);
			myadd=InetAddress.getLocalHost();
			System.out.println(add1);
			
			for(Object xx : add) {
				System.out.println(xx);
			}
			
			System.out.println(myadd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
