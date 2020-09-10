package baekjoon;

import java.util.Scanner;

public class Ex_1644 {

	public static void main(String[] args) {
		//소수의 연속합
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num+1];
		
		for(int i=2;i<=num;i++) {
			arr[i]=i;
		}
		for(int i=2;i<=num;i++) {
			if(arr[i]==0)
				continue;
			for(int j=2*i;j<=num;j+=i) {
					arr[j]=0;
			}
		}

		int s=2;
		int e=2;
		int sum=0;
		int cnt=0;
		while(true) {
			if(s<=num && arr[s]== 0) {
				s++;
				continue;
			}
			if(sum >= num) sum-=arr[s++];
			else if(e>num) break;
			else sum+=arr[e++];
			if(sum==num)cnt++;
		}
		System.out.println(cnt);

	}

}
