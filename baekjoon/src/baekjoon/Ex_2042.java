package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ex_2042{
	public static void main(String[] args) throws Exception{
		// 구간 합 구하기 - 세그먼트 트리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		for(int i=0;i<n;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Tree tree = new Tree(n, arr);
		tree.init(0, n-1, 1);
		
		for(int i=0;i<m+k;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a == 1) {
				tree.update(0, n-1, 1, b-1, c-tree.arr[b-1]);
				tree.arr[b-1] = c;
			}else {
				bw.append(tree.sum(0, n-1, 1, b-1, c-1)+"\n");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
class Tree{
	long[] arr;
	long[] tree;
	
	public Tree(int n, long[] arr) {
		this.arr = arr;
		tree = new long[n*4];
	}
	public long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start+end)/2;
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	public long sum(int start, int end, int node, int left, long right) {
		if(start > right || end < left) {
			return 0;
		}
		if(start >= left && end <= right) {
			return tree[node];
		}
		int mid = (start+end)/2;
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
	}
	public void update(int start, int end, int node, int index, long dif) {
		if(start > index || end < index) {
			return;
		}
		tree[node]+=dif;
		if(start == end) {
			return;
		}
		int mid = (start+end)/2;
		update(start, mid, node*2, index, dif);
		update(mid+1, end, node*2+1, index, dif);
	}
}