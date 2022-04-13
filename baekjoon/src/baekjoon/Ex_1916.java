package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Ex_1916 {

    static List<Node>[] list;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
    	//최소비용 구하기 - 다익스트라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n+1];
        visited = new boolean[n+1];
        list = new List[n+1];

        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList();
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        dijkstra(start);
        System.out.println(dist[end]);
    }
    static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));

        while(!q.isEmpty()) {
            Node curNode = q.poll();

            if(visited[curNode.end])
                continue;
            visited[curNode.end] = true;

            for(int i=0;i<list[curNode.end].size();i++) {
                Node nextNode = list[curNode.end].get(i);
                int cost = curNode.weight + nextNode.weight;
                if(cost < dist[nextNode.end]) {
                    dist[nextNode.end] = cost;
                    q.offer(new Node(nextNode.end,cost));
                }
            }
        }
    }
}
class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(Node o) {
        return weight-o.weight;
    }
}

