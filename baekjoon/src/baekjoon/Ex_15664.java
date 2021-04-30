package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_15664 {

	static int m;
	static List<Integer> list = new ArrayList<>();;
	static int[] check = new int[10001];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//백트래킹 N과 M(10)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!list.contains(num))
				list.add(num);
			check[num]+=1;
		}
		list.sort(null);
		comb(0,new int[m],0);
		System.out.println(sb);
	}
	static void comb(int pre,int[] output,int depth) {
		if(depth == m) {
			for(int i=0;i<m;i++)
				sb.append(output[i]+" ");
			sb.append("\n");
			return;
		}
		for(int i=0;i<list.size();i++) {
			int num = list.get(i);
			if(check[num] > 0 && pre <= num) {
				check[num]-=1;
				output[depth] = num;
				comb(num,output,depth+1);
				check[num]+=1;
			}
		}
	}

}
