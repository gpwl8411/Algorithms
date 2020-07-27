package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex_9088 {

	public static void main(String[] args) throws IOException {
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			String str[] = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int[] diamond = new int[10001];
			for(int i=0;i<n;i++) {
				int index = Integer.parseInt(br.readLine());
				diamond[index]+=1;
			}
			int s=0;
			int e=1;
			int maxCnt=0;
			int cnt=0;
			while(s<=e && e<1001) {
				if((e-s)<=k) {
					cnt+=diamond[e];
					maxCnt=Math.max(cnt, maxCnt);
					e++;
					
				}else {
					cnt-=diamond[s];
					s++;
					
				}				
			}
			bw.write("#"+test_case+" "+maxCnt+"\n");
			
		}
		bw.flush();
	}

}
