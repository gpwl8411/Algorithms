////14438에서 세그먼트트리 클래스를 사용하기 때문에 전체 주석처리 해놓음.
//
//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class ex_2042 {
//
//	public static void main(String[] args) throws IOException{
//		// TODO Auto-generated method stub
////		  int[] arr = {5, 3, 7, 9, 6, 4, 1, 2, 1};
////
////	        SegmentTree segmentTree = new SegmentTree(arr, 9);
////
////	        System.out.println(Arrays.toString(segmentTree.segmentArr));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter  out= new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
//		
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		int k = Integer.parseInt(st.nextToken());
//		long[] arr = new long[n];
//		for(int i=0;i<n;i++){
//			arr[i] = Integer.parseInt(in.readLine());
//		}
//		SegmentTree segmentTree = new SegmentTree(arr, n);
//		for(int i=0;i<m+k;i++){
//			st = new StringTokenizer(in.readLine()," ");
//			int type = Integer.parseInt(st.nextToken());
//			int index = Integer.parseInt(st.nextToken());
//			int val = Integer.parseInt(st.nextToken());
//			if(type==1){//값교체경우
//			//	System.out.println();
//				segmentTree.update(index-1,val,1,0,n-1);
//				continue;
//			}
////			System.out.println(segmentTree.query(index-1,val-1,1,0,n-1));
//			//구간합경우
//			 out.write(segmentTree.query(index-1,val-1,1,0,n-1)+"\n") ;
//			
//		}
//		out.flush();
//		
//	}
//
//}
//
//class SegmentTree {
//
//    long[] segmentArr; // The array that stores segment tree nodes
//
//    SegmentTree(long[] arr, int n) {
//
//        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
//
//        int segmentSize = (int) Math.pow(2, x) * 2 - 1;
//
//        segmentArr = new long[segmentSize];
//        //segmentArr = new int[n * 4];
//
//        init(arr, 0, n - 1, 1);
//    }
//
//    // node를 root로 하는 서브트리를 초기화하고, 이 구간의 최소치를 반환한다
//    long init(long[] arr, int left, int right, int node) {
//
//        if (left == right) {
//
//            return segmentArr[node] = arr[left];
//        }
//
//        int mid = (left + right) / 2;
//
//        segmentArr[node] += init(arr, left, mid, node * 2);
//        segmentArr[node] += init(arr, mid + 1, right, node * 2 + 1);
//
//        return segmentArr[node];
//    }
//    long update(int index,int newVal,int node,int nodeLeft,int nodeRight){
//    	if(index < nodeLeft || index>nodeRight) return segmentArr[node];
//    	
//    	if(nodeLeft==nodeRight){
//    		//segmentArr[index]=newVal;
//    		return segmentArr[node]=newVal;
//    	}
//    	int mid=(nodeLeft+nodeRight)/2;
//    	//구간합을 구하기 때문에 update시 각 자식노드 더한것이 부모노드가 됨.
//    	return segmentArr[node]=update(index,newVal,node*2,nodeLeft,mid)+update(index,newVal,node*2+1,mid+1,nodeRight);
//    	
//    	
//    }
//    long query(int indexLeft,int indexRight,int node,int nodeLeft,int nodeRight){
//    	if(indexLeft>nodeRight || indexRight < nodeLeft){
//    		return 0;
//    	}
//    	if(indexLeft <= nodeLeft && indexRight >= nodeRight){
//    		//System.out.println(node);
//    		return segmentArr[node];
//    	}
//    	int mid = (nodeLeft+nodeRight)/2;
//    	return query(indexLeft,indexRight,node*2,nodeLeft,mid)+query(indexLeft,indexRight,node*2+1,mid+1,nodeRight);
//    }
//
//}
