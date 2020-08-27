package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FarNode {

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 2 }, { 5, 4 }, { 3, 4 }, { 2, 1 }, { 2, 5 }, { 5, 6 }, { 4, 6 } };

		GraphList list = new GraphList(n);
		boolean[] visited = new boolean[n + 1];
		int[] count = new int[n + 1];
		int max;
		int answer = 1;

		for (int i = 0; i < edge.length; i++) {
			list.put(edge[i][0], edge[i][1]);
		}
		visited[1] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while (!q.isEmpty()) {
			int conNode = q.poll();
			for (int i = 0; i < list.graphList.get(conNode).size(); i++) {
				int node = list.graphList.get(conNode).get(i);
				if (!visited[node]) {
					count[node]=count[conNode]+1;
					visited[node]=true;
					q.add(node);
				}
			}
		}

		Arrays.sort(count);
		max = count[count.length - 1];
		for (int i = count.length - 2; i >= 0; i--) {
			if (count[i] == max)
				answer++;
		}
		System.out.println(answer);

	}

}

class GraphList {
	ArrayList<ArrayList<Integer>> graphList;

	GraphList(int size) {
		this.graphList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= size; i++) {
			graphList.add(new ArrayList<Integer>());
		}
	}

	public void put(int x, int y) {
		graphList.get(x).add(y);
		graphList.get(y).add(x);
	}

}
