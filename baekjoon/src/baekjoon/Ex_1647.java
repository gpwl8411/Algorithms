package baekjoon;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Ex_1647 {
    static int[] parent;
    static int parentNum;

    public static void main(String[] args) throws Exception{
    	// 도시 분할 계획 - 크루스칼
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cost = 0;
        List<Edge> list = new ArrayList<>();
        parent = new int[n+1];
        parentNum = n;
        for(int i=1;i<=n;i++) {
            parent[i] = i;
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Edge(a,b,c));
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++) {
            int a = list.get(i).a;
            int b = list.get(i).b;
            int dis = list.get(i).dis;

            if(findParent(a) != findParent(b)) {
                cost+=dis;
                union(a,b);
            }
            if(parentNum == 2)
                break;
        }

        System.out.println(cost);

    }
    static int findParent(int x) {
        if(parent[x] == x)
            return x;
        return parent[x] = findParent(parent[x]);
    }
    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a == b)
            return;

        parentNum--;
        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }
}
class Edge implements Comparable<Edge> {
    int a;
    int b;
    int dis;

    public Edge(int a, int b, int dis) {
        this.a = a;
        this.b = b;
        this.dis = dis;
    }

    @Override
    public int compareTo(Edge o) {
        return dis - o.dis;
    }
}
