package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_2143 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//누적합/이분탐색 두 배열의 함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> listA = new ArrayList<>();
		for(int i=0;i<n;i++) {
			int sum = 0;
			for(int j=i;j<n;j++) {
				sum+=a[j];
				listA.add(sum);
			}
		}
		List<Integer> listB = new ArrayList<>();
		for(int i=0;i<m;i++) {
			int sum = 0;
			for(int j=i;j<m;j++) {
				sum+=b[j];
				listB.add(sum);
			}
		}

		Collections.sort(listA);
		Collections.sort(listB);
		
		long cnt = 0;
		for(int num : listA) {
			int target = t-num;
			//이분탐색
			cnt +=upperBound(listB,target) - lowerBound(listB,target);
		}
		System.out.println(cnt);
	}
	static int upperBound(List<Integer> sum,int target) {
		int left = 0;
		int right = sum.size();
		
		while(left < right){
			int mid = (left+right)/2;
			if(sum.get(mid) <= target) {
				left=mid+1;
			}else
				right = mid;
		}
		return right;
	}
	static int lowerBound(List<Integer> sum,int target) {
		int left = 0;
		int right = sum.size();
		
		while(left < right) {
			int mid = (left+right)/2;
			if(sum.get(mid) < target)
				left = mid+1;
			else
				right = mid;
		}
		return right;
	}

}
/*
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(temp[i]);
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        temp = br.readLine().split(" ");
        for (int i = 0; i < m; i++)
            b[i] = Integer.parseInt(temp[i]);
        int[] sumA = new int[n * (n + 1) / 2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                sumA[idx++] = sum;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        long ans = 0;
        for (int sum : sumA)
            ans += map.getOrDefault(t - sum, 0);
        System.out.println(ans);
    }
}
 */