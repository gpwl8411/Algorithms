package programers;

import java.util.Stack;

public class KakaoIntern21_EditTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 카카오인턴21 표편집
		int n = 3;
		int k = 2;
		String[] cmd = { "C","C","Z" };

		Stack<Node> zNode = new Stack<>();
		Node root = new Node(0);
		Node curNode = root;
		for (int i = 1; i < n; i++) {
			Node node = new Node(i);
			curNode.next = node;
			node.prev = curNode;
			curNode = node;
		}
		Node tail = curNode;
		root.prev = tail;
		tail.next = root;
		curNode = root;
		while (k-- > 0) {
			curNode = curNode.next;
		}
		
		for (int i = 0; i < cmd.length; i++) {
			String[] s = cmd[i].split(" ");
			if (s.length == 1) {
				if (s[0].equals("C")) {
					curNode.prev.next = curNode.next;
					curNode.next.prev = curNode.prev;
					zNode.push(curNode);
					if (curNode == root) {
						root = curNode.next;
						curNode = root;
					}else if (curNode == tail) {
						tail = curNode.prev;
						curNode = tail;
					}else {
						curNode = curNode.next;
					}
				} else {
					Node node = zNode.pop();
					Node tmp = node.prev.next;
					node.prev.next = node;
					tmp.prev = node;
					if(node.data < root.data)
						root = node;
					else if(node.data > tail.data)
						tail = node;
				}
			} else {
				int num = Integer.parseInt(s[1]);
				if (s[0].equals("U")) {
					while (num-- > 0) {
						curNode = curNode.prev;
					}
				} else {
					while (num-- > 0) {
						curNode = curNode.next;
					}
				}
			}
		}
		StringBuilder ans = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			if(root.data == i) {
				ans.append("O");
				root=root.next;
			}
			else {
				ans.append("X");
			}
		}
		System.out.println(ans.toString());

	} 

	static class Node {
		Node prev;
		Node next;
		int data;

		Node(int data) {
			this.data = data;
			prev = null;
			next = null;
		}
	}

}
