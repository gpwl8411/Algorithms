package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_1725 {

	static int[] arr;
	static int[] tree;
	static int n;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 히스토 그램 - 세그먼트 트리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		if(n==0) {
			return;
		}
		arr = new int[n];
		tree = new int[n*4];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		init(0,n-1,1);
		System.out.println(getMax(0,n-1));
		
	}
	// 최소 높이 인덱스 트리 생성
	static int init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = start;
		}			
		int mid = (start+end)/2;
		int leftNode = init(start,mid,node*2);
		int rightNode = init(mid+1,end,node*2+1);
		
		return tree[node] = arr[leftNode] < arr[rightNode] ? leftNode : rightNode;
		
	}
	// 구간 최소 높이 인덱스 
	static int query(int start, int end, int node, int left, int right) {
		if(start > right || end < left)
			return -1;
		if(left <= start && right >= end)
			return tree[node];
		
		int mid = (start+end)/2;
		int leftNode = query(start,mid,node*2,left,right);
		int rightNode = query(mid+1,end,node*2+1,left,right);
		if(leftNode == -1)
			return rightNode;
		if(rightNode == -1)
			return leftNode;
		if(arr[leftNode] <= arr[rightNode])
			return leftNode;
		else
			return rightNode;
	}
	// 최소 높이 인덱스를 기준으로 left, right 합 구함
	static long getMax(int left, int right) {
		if(left > right)
			return -1;
		int m = query(0,n-1,1,left,right);
		long width = (long)(right-left+1)*(long)arr[m];
				
		if(left != m) {
			long leftMax = getMax(left,m-1);
			width = Math.max(width, leftMax);
		}
		if(right != m) {
			long rightMax = getMax(m+1,right);
			width = Math.max(width, rightMax);
		}
		return width;
	}
}
