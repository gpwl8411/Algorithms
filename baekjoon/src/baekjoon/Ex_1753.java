package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex_1753 {

	private static final int INF = Integer.MAX_VALUE;
    static List<Point2> list[];
    static int dist[];
    static boolean check[];

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[v + 1];
		dist = new int[v+1];
		check = new boolean[v+1];
		
		 Arrays.fill(dist, INF);
		 for(int i=0;i<list.length;i++) {
			 list[i] = new ArrayList<>();			
		 }
		st = new StringTokenizer(br.readLine());
		int k =Integer.parseInt(st.nextToken());
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int startV = Integer.parseInt(st.nextToken());
			int endV = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			//방향 그래프이므로 한쪽만 추가를 해줌
			list[startV].add(new Point2(endV,w));

		}
		dijkstra(k);
		for(int i=1;i<list.length;i++) {
			if(dist[i]==INF)
				bw.append("INF\n");
			else
				bw.append(String.valueOf(dist[i])+"\n");
		}
		bw.flush();
		
	}
	static void dijkstra(int start){

        PriorityQueue<Point2> queue = new PriorityQueue<>();
        queue.add(new Point2(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()){
            Point2 curPoint = queue.poll();
            int curNode = curPoint.end;


            if(check[curNode] == true) continue;
            check[curNode] = true;

            for(int i = 0; i < list[curNode].size(); i++){
                Point2 nextNode = list[curNode].get(i);

                //기존의 경로보다 새로운 경로가 작을 경우
                if(dist[nextNode.end] > dist[curNode] + nextNode.weight){
                    dist[nextNode.end] = dist[curNode] + nextNode.weight;
                    queue.add(new Point2(nextNode.end, dist[nextNode.end]));
                }
            }
//            System.out.println("curNode="+curNode);
//            for(int i=1;i<dist.length;i++) {
//            	System.out.print(dist[i]+" ");
//            }
        }

    }

}
class Point2 implements Comparable<Point2>{
    int end;
    int weight;

    public Point2(int end, int weight){this.end = end; this.weight = weight;}

    @Override
    public int compareTo(Point2 o) {
    	//오름차순
        return weight - o.weight;
    }
}
