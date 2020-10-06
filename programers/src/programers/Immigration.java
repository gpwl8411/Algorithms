package programers;

import java.util.Arrays;

public class Immigration {

	public static void main(String[] args) {
		// 이분탐색 입국심사
		int n = 10;
		int[] times = {1,5};
		
		Arrays.sort(times);
		
		long left = 1;
		long right =(long) times[times.length-1]*(long)n;
		
		long answer=Long.MAX_VALUE;
		while(left <= right) {
			
			long mid = (left+right)/2;
			if(isAvailable(times,mid,n)) {
				answer = Math.min(answer, mid);
				right = mid-1;
			}else
				left = mid+1;
			
		}
		System.out.println(answer);
		
		

	}
	static boolean isAvailable(int[] times,long mid,int n) {
		
		long cnt=0;
		
		for(int i=0;i<times.length;i++) {
			cnt += mid/times[i];
		}
		if(cnt >= n) 
			return true;
		else
			return false;
	}

}
