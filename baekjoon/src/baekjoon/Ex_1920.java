package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_1920 {

	static int[] numbers;
	static boolean flag;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//이분탐색 수 찾기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			numbers[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(numbers);
				
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		while(m-- > 0) {
			int num = Integer.parseInt(st.nextToken());
			flag = false;
			search(num,0,n-1);
			if(flag)
				bw.append("1\n");
			else
				bw.append("0\n");
			
		}
		
		bw.flush();
		
	}
	static void search(int num,int left,int right) {
		
		int mid = (left+right)/2;
		
		if(numbers[mid]==num) {
			flag=true;
			return;
		}
		if(left>=right)
			return;
		if(num < numbers[mid])
			search(num,left,mid);
		else
			search(num,mid+1,right);
		
	}

}
