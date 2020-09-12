package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Ex_1484 {

	public static void main(String[] args) throws IOException {
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int g = sc.nextInt();
//		int[] arr = new int[g+1];
		int s=1;
		int e=1;
//		int w=0;
		while(true) {
//			int w = e*e -s*s;
			if(e*e-s*s > g) {
				if(e-s==1) break;
				else s++;
			}

			else e++;
			if(e*e - s*s == g) {
//				bw.append(String.valueOf(e)+"\n");
				sb.append(String.valueOf(e)+"\n");
				s++;
			}
			
		}
		if(sb.toString().equals("")) System.out.println(-1);
		else System.out.println(sb.toString());
		
//		bw.flush();
	}

}
