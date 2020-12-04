package programers;

import java.util.HashMap;
import java.util.Map;

public class S_W18_English {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//섬머/윈터코딩2018 영어 끝말잇기
		
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] answer = new int[2];
		Map<String,Integer> map = new HashMap<>(); 
		for(int i=0;i<words.length;i++) {
			if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
				answer[0] = (i%n)+1;
				answer[1] = i/n+1;
				break;
			}
			if(map.containsKey(words[i])) {
				answer[0] = (i%n)+1;
				answer[1] = i/n+1;
				break;
			}
			map.put(words[i], 0);
		}
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	
		
	
	}

}
