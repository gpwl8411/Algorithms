package programers;

import java.util.Arrays;

public class kakao18_song {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		String m = "ABCDE";
		String answer="";
		
		String[] re = m.split("");
		for(int i=0;i<re.length;i++){
			if(re[i].equals("#")){
				re[i]="";
				re[i-1]=re[i].toLowerCase();
			}
		}
		m = arrayToString(re,"");

		int tempT=0;
		for(int i=0;i<musicinfos.length;i++){
			int h1 = Integer.parseInt(musicinfos[i].substring(0,2));
			int m1 = Integer.parseInt(musicinfos[i].substring(3,5));
			int h2 = Integer.parseInt(musicinfos[i].substring(6,8));
			int m2 = Integer.parseInt(musicinfos[i].substring(9,11));

			int time = (h2-h1)*60+m2-m1;
			if(time >= m.length()){

				String[] str = musicinfos[i].split(",");
				String[] re2 = str[3].split("");
				for(int j=0;j<re2.length;j++){
					if(re2[j].equals("#")){
						re2[j]="";
						re2[j-1]=re2[j].toLowerCase();
					}
				}
				str[3] = arrayToString(re2,"");
				String repeated = new String(new char[time/str[3].length()+time%str[3].length()]).replace("\0", str[3]);
				//System.out.println(repeated);
				if(repeated.contains(m)){

						if(tempT<time){
							answer=str[2];
							tempT=time;
						}
					
				}
			}
		}
		if(answer.equals("")){
			answer="(None)";
		}
		System.out.println(answer);
	}
	public static String arrayToString(String[] array, String delimiter) {
	    StringBuilder arTostr = new StringBuilder();
	    if (array.length > 0) {
	        arTostr.append(array[0]);
	        for (int i=1; i<array.length; i++) {
	            arTostr.append(delimiter);
	            arTostr.append(array[i]);
	        }
	    }
	    return arTostr.toString();
	}

}
