package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_16947 {
	static Node[] nodes;
	static boolean[] visited;
	static boolean[] cycleNode;
	static boolean cycle;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		nodes = new Node[n+1];
		visited = new boolean[n+1];
		cycleNode = new boolean[n+1];
		
		for(int i=0;i<=n;i++) {
			Node node = new Node(i);
			nodes[i] = node;
		}
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			connectNode(nodes[n1],nodes[n2]);
		}
		for(int i=1;i<=n;i++) {
			cycle= false;
			Arrays.fill(visited, false);
			dfs(nodes[i],nodes[i],1);
			if(cycle) {
				cycleNode[i]=true;
			}
		}
		int cnt;
		for(int i=1;i<=n;i++) {
			if(!cycleNode[i]) {
				cnt = bfs(nodes[i],n);
			}
			else cnt=0;
			bw.append(String.valueOf(cnt));
			bw.append(' ');
		}
		bw.flush();
	}

	static int bfs(Node node,int N) {
		int cnt=1;
		Queue<ArrayList<Node>> q = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		q.add(node.connect);
		visit[node.num] = true;
        
		while(!q.isEmpty()) {
			ArrayList<Node> next = q.poll();
			Node addNode = new Node(0);
			for(Node n : next) {
				if(cycleNode[n.num]) {
					visit[n.num]=true;
					return cnt;
				}
				if(!visit[n.num]) {
					addNode.connect.addAll(n.connect);
				}
				visit[n.num]=true;
			}
			if(addNode.connect.size()!=0) {
				q.add(addNode.connect);
			}
			cnt++;
		}
		return cnt;
	}
	static void dfs(Node start,Node cur,int cnt) {
		if(cur.num == start.num && cnt >= 3) {
			cycle=true;
			return;
		}
		visited[cur.num]=true;
		for(int i=0;i<cur.connect.size();i++) {
			Node next = cur.connect.get(i);
			if(!visited[next.num]) {
				dfs(start,next,cnt+1);
			}else {
				if(next.num == start.num && cnt>=3) {
					cycle = true;
					return;
				}
			}
			
		}
		
	}
	static void connectNode(Node node,Node other) {
		node.connect.add(other);
		other.connect.add(node);
	}

}
class Node{
	ArrayList<Node> connect;
	int num;
	Node(int num){
		this.num = num;
		connect = new ArrayList<>();
	}
	@Override
	public String toString() {
		return "Node [ num=" + num + "]";
	}
	
	
}
