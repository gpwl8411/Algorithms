package programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kakao19_RoadGame {
	static int index=0;
	public static void main(String[] args) {

		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},
				{1,3},{8,6},{7,2},{2,2}};
//		boolean[][] node = new boolean[1001][100001];
		List<Node> list = new ArrayList<>();
		int[][] answer= new int[2][nodeinfo.length];
		for(int i=0;i<nodeinfo.length;i++) {
			int x = nodeinfo[i][0];
			int y = nodeinfo[i][1];
			list.add(new Node(x,y,i+1));
		}
		Collections.sort(list);
		Node root = list.get(0);
		for(int i=1;i<list.size();i++) {			
			connectNode(root,list.get(i));
		}
		preOrder(answer,root);
		index=0;
		postOrder(answer,root);
//		for(int i : answer[0]) {
//			System.out.println(i);
//		}
		
		
	}
	static void connectNode(Node parent,Node child) {
		
		if(parent.x > child.x) {
			if(parent.left==null) {
				parent.left = child;
			}else {
				connectNode(parent.left,child);
			}
		}
		
		else {
			if(parent.right==null) {
				parent.right = child;
			}else {
				connectNode(parent.right,child);
			}
		}
	}
	//
	static void preOrder(int[][] answer , Node root) {
		if(root!=null) {
		//root
		answer[0][index++] = root.num;
		//left
		preOrder(answer,root.left);
		//right
		preOrder(answer,root.right);
		}
	}
	static void postOrder(int[][] answer , Node root) {
		if(root!=null) {
		//left
		postOrder(answer,root.left);
		//right
		postOrder(answer,root.right);
		//root
		answer[1][index++] = root.num;
		}
	}

}
class Node implements Comparable<Node>{
	int x;
	int y;
	int num;
	Node left;
	Node right;
	Node(int x,int y,int num){
		this.x=x;
		this.y=y;
		this.num=num;
	}
	@Override
	public int compareTo(Node o) {
		if(y<o.y) {
			return 1;
		}else if(y==o.y) {
			if(x>o.x) {
				return 1;
			}
		}
		return -1;
	}
	
	
}