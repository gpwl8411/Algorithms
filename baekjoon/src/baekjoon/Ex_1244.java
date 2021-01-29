package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_1244 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//스위키 켜고 끄기 구현
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int studentN = Integer.parseInt(br.readLine());
		
		while(studentN-- > 0) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(gender==1) {//남학생
				for(int i=1;i<=n;i++) {
					if(i%num==0)
						arr[i] = arr[i]==1 ? 0 : 1;
				}
			}
			else {//여학생
				arr[num] = arr[num]==1 ? 0 : 1;
				for(int i=1;i<=n;i++) {
					if(num-i >0 && num+i <n+1 && arr[num-i]==arr[num+i]) {
						int changeN = arr[num-i]==1 ? 0 :1;
						arr[num-i] = changeN;
						arr[num+i] = changeN;
					}
					else
						break;
				}
			}
		
		}
		for(int i=1;i<=n;i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0)
				System.out.println();
		}
	}

}
