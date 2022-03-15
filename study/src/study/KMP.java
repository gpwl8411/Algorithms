package study;

import java.util.*;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] ans = getPi("abca");
//		for(int i : ans)
//			System.out.print(i+" ");
		List<Integer> ans2 = kmp("ababcab", "abca");
		System.out.println(ans2.size());
		for(int i : ans2) {
			System.out.print(i+" ");
		}
	}
	public static List<Integer> kmp(String src, String search){
		int[] pi = getPi(search);
		List<Integer> res = new ArrayList<>();
		int begin = 0, match = 0;
		
		while(begin <= src.length()-search.length()) {
			if(match < search.length() && src.charAt(begin+match) == search.charAt(match)) {
				match++;
				if(match == search.length()) {
					res.add(begin);
				}
			}else {
				if(match == 0) {
					begin++;
				}
				else {
					begin += match - pi[match-1];
					match = pi[match-1];
				}
			}
		}
		return res;
	}
	/**
	 * 탐색 문자열의 접두, 접미사를 미리 계산해놓는 배열
	 * 
	 * @param search
	 * @return
	 */
	public static int[] getPi(String search) {
		int[] res = new int[search.length()];
		int begin = 1, match = 0;
		
		while(begin+match < search.length()) {
			if(search.charAt(begin+match) == search.charAt(match)) {
				match++;
				res[begin+match-1] = match;
			}else {
				if(match == 0) {
					begin++;
				}else {
					begin += match-res[match-1];
					match = res[match-1];
				}
			}
		}
		return res;
	}

}
