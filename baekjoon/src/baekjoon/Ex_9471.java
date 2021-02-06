package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ex_9471 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//피사노 주기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		int p = Integer.parseInt(br.readLine());
		
		while(p-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int f1 = 0;
			int f2 = 1;
			int cnt=0;
			while(true) {
				if(f1 == 0 && f2 == 1 && cnt != 0) {
	                break;
	            }
	            int temp = f1;
	            f1 = f2;
	            f2 = (temp + f1) % m;
	            cnt ++;
			}
			bw.append(n+" "+cnt+"\n");
			
		}
		bw.flush();
		
	}

}
