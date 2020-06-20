package programers;

import java.util.ArrayList;

public class kakao18_news {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "aa1+aa2".toUpperCase();
		String str2 = "AAAA12".toUpperCase();
		int inter=0;
		int union=0;
		int answer=0;
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<String> a2 = new ArrayList<String>();
		for(int i=0;i<str1.length()-1;i++){
			int a =(int)str1.charAt(i);
			int b =(int)str1.charAt(i+1);
			if(65<=a && a<=90 && 65<=b && b<=90)
				a1.add((char)a+""+(char)b);
			
		}
		for(int i=0;i<str2.length()-1;i++){
			int a =(int)str2.charAt(i);
			int b =(int)str2.charAt(i+1);
			if(65<=a && a<=90 && 65<=b && b<=90)
				a2.add((char)a+""+(char)b);
		}
		union = a1.size()+a2.size();
		System.out.println(a1.size());
		for(int i=0;i<a1.size();i++){
//			System.out.println(a1.get(i));
			Outer:
			for(int j=0;j<a2.size();j++){
				if(a1.get(i).equals(a2.get(j))){
//					System.out.println(a1.get(i));
					inter++;
//					a1.remove(i);
					System.out.println(j+":"+a1.get(i));
					a2.remove(j);
//					i=0;
					break Outer;
				}
//				if(j==a2.size()-1)
//					a1.remove(i);
			}
		}
		union=union-inter;
		if(union==0) answer=65536;
		else if(inter==0) answer=0;
		else answer = inter*65536/union;
		System.out.println(answer);
		System.out.println(union);
		System.out.println(inter);
	}

}
