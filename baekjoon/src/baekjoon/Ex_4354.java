package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex_4354 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 백준 4354 문자열 제곱 kmp
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String s = br.readLine();
			if(s.equals(".")) {
				break;				
			}
			int[] pi = getPi(s);
			int len = s.length();
			if(len%(len-pi[len-1])!=0) {
				bw.append("1\n");
			}else {
				bw.append(len/(len-pi[len-1])+"\n");
			}
		}
		
		bw.flush();
		br.close();
		bw.close();

	}
	public static int[] getPi(String srt) {
		int[] ret = new int[srt.length()];
		int begin = 1, match = 0;
		
		while(begin+match < srt.length()) {
			if(srt.charAt(begin+match) == srt.charAt(match)) {
				match++;
				ret[begin+match-1] = match;
			}else {
				if(match == 0) {
					match++;
				}
				else {
					begin += match - ret[match-1];
					match = ret[match-1];
				}
			}
		}
		return ret;
	}

}
