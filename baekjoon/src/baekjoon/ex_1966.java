package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_1966 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int test = Integer.parseInt(in.readLine());
		for(int i=0;i<test;i++){
			st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());//문서 수
			int m = Integer.parseInt(st.nextToken());//궁금한 문서
			//String[] str = in.readLine().split(" ");
			st = new StringTokenizer(in.readLine(), " ");
			Queue<Integer> q = new LinkedList<>();
			int cnt=0;
			int[] p = new int[n];
			for(int j=0;j<n;j++){
				p[j]=Integer.parseInt(st.nextToken());
				//System.out.println(p[j]);
				q.add(j);
//				System.out.println(q.peek());
			}
			while(!q.isEmpty()){
				int doc = q.poll();
				//System.out.println(doc);
				if(check(doc,p)){
					cnt++;
					p[doc]= 0;
					if(doc==m){
						//System.out.println(cnt);
						out.write(cnt+"\n");
						break;
					}
					
				}else{
					q.add(doc);
				}
			}
			
			
		}
		out.flush();
	}
	static boolean check(int doc,int[] p){
		boolean result = true;
		for(int i=0;i<p.length;i++){
			if(p[i]>p[doc]){
				result = false;
			}
		}
		return result;
	}

}
