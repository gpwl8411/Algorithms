package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex_4195 {

	static int[] parent;
	static int[] cnt;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//친구 네트워크
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t= Integer.parseInt(br.readLine());
		
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			ArrayList<String> list = new ArrayList<>();
			HashMap<String,Integer> map = new HashMap<>();
			StringTokenizer st;
			parent = new int[n*2+1];
			cnt = new int[n*2+1];
			for(int i=1;i<parent.length;i++) {
				parent[i] = i;
				cnt[i]=1;
			}
			int idx = 1;
			while(n-->0) {
				st = new StringTokenizer(br.readLine());
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				if(!map.containsKey(s1)) {
					map.put(s1, idx++);
				}
				if(!map.containsKey(s2)) {
					map.put(s2, idx++);
				}
				
				union(map.get(s1),map.get(s2));
				bw.append(cnt[find(map.get(s1))]+"\n");
			}
			
		}
		bw.flush();
	}
	static int find(int x) {
		if(parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if( x != y) {
			parent[y] = x;
			cnt[x]+=cnt[y];
		}
	}

}
