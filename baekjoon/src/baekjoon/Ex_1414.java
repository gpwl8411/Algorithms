package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex_1414 {

	static int[] parent;
	static List<Computer> computers;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//최소 스패닝 트리 - 불우이웃 돕기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		computers = new ArrayList<>();
		int total = 0;
		for(int i=1;i<=n;i++)
			parent[i] = i;
		for(int i=1;i<=n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				char c = s.charAt(j);
				int val = 0;
				if(c >= 'a' && c <='z' )
					val = c-'a'+1;
				else if(c >= 'A' && c <= 'Z')
					val = c-'A'+27;
				else
					continue;
				computers.add(new Computer(i,j+1,val));
				total+=val;
			}
		}
		
		Collections.sort(computers);

		int result = 0;
		for(int i=0;i<computers.size();i++) {
			Computer computer = computers.get(i);
			if(!find(computer.start,computer.end)) {
				makeUnion(computer.start,computer.end);
				result+=computer.val;
			}
				
		}
		if(isAllConnect())
			System.out.println(total-result);
		else
			System.out.println(-1);
	}
	static boolean isAllConnect() {
		for(int i : parent) {
			if(parent[i]!=1 && i!=0)
				return false;
		}
		return true;
	}
	static boolean find(int start, int end) {
		if(parent(start)==parent(end))
			return true;
		else 
			return false;
	}
	static int parent(int node) {
		if(parent[node] == node)
			return node;
		else
			return parent[node] = parent(parent[node]); 
	}
	static void makeUnion(int start, int end) {
		start = parent(start);
		end = parent(end);
		
		if(start < end)
			parent[end] = start;
		else
			parent[start] = end;
	}

}
class Computer implements Comparable<Computer>{
	int start;
	int end;
	int val;
	
	Computer(int start,int end,int val){
		this.start =start;
		this.end = end;
		this.val = val;
	}
	
	@Override
	public int compareTo(Computer o) {
		return val - o.val;
	}
}
