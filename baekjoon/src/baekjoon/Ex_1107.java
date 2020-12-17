package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_1107 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//브루트포스 리모컨
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		String[] arr = new String[m];
		if(m!=0) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<m;i++) {
				arr[i] = st.nextToken();
			}
		}
		if(m==10) {
			System.out.println(Math.abs(100-n));
			return;
		}
		if(n==100) {
			System.out.println(0);
			return;
		}
		int num=0;
		int min = Integer.MAX_VALUE;

		while(num <= 599999) {
			String s = String.valueOf(num);
			boolean flag = true;
			
			outer:
			for(int i=0;i<m;i++) {
				for(int j=0;j<s.length();j++) {
					if(arr[i].equals(s.charAt(j)+"")) {
						flag = false;
						break outer;
					}
				}
			}
			
			if(flag) {
				min = Math.min(min, Math.abs(num-n)+s.length());
				min = Math.min(min, Math.abs(100-n));
			}
			num++;
		}
		System.out.println(min);
	}

}
