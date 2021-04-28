package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Ex_1991 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//트리 트리순회
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		
		while(n-- > 0) {
			st = new StringTokenizer(br.readLine());
			char node = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree.insert(node, left, right);
		}
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}

}
class NodeT{
	char data;
	NodeT left;
	NodeT right;
	
	NodeT(char data){
		this.data = data;
	}
}
class Tree{
	NodeT root;
	
	void insert(char data, char leftData, char rightData){
		if(root == null) {
			if(data!='.') 
				root = new NodeT(data);
			if(leftData!='.')
				root.left = new NodeT(leftData);
			if(rightData!='.')
				root.right = new NodeT(rightData);
		}else {
			search(root,data,leftData,rightData);
		}
	}
	void search(NodeT root, char data, char leftData, char rightData) {
		if(root == null) 
			return;
		if(root.data == data) {
			if(leftData!='.')
				root.left = new NodeT(leftData);
			if(rightData!='.')
				root.right = new NodeT(rightData);
		}else {
			search(root.left,data,leftData,rightData);
			search(root.right,data,leftData,rightData);
		}
	}
	//루트 -> 왼-> 오
	void preOrder(NodeT root) {
		System.out.print(root.data);
		if(root.left!=null)
			preOrder(root.left);
		if(root.right!=null)
			preOrder(root.right);
	}
	//왼-> 루트-> 오
	void inOrder(NodeT root) {
		if(root.left!=null) 
			inOrder(root.left);
		System.out.print(root.data);
		if(root.right!=null)
			inOrder(root.right);
	}
	//왼-> 오른-> 루트
	void postOrder(NodeT root) {
		if(root.left!=null)
			postOrder(root.left);
		if(root.right!=null)
			postOrder(root.right);
		System.out.print(root.data);
	}
}
