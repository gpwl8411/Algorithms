package swea;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Ex_10032 {

	public static void main(String[] args) throws IOException {

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sc.nextLine(); //버퍼 비우기용
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = sc.nextLine();
			String[] sArr = s.split(" ");
			int n = Integer.parseInt(sArr[0]);
			int k = Integer.parseInt(sArr[1]);
			int[] arr = new int[k];
			for(int i=0;i<n;i++) {
				arr[i%k] += 1;
			}
			int answer = arr[0]-arr[k-1];
			bw.write("#"+test_case+" "+answer+"\n");
		}
		bw.flush();
	}

}
