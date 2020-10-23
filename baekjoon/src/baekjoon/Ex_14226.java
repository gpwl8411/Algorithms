package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ex_14226 {
	static int s;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{

		//bfs 이모티콘
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = Integer.parseInt(br.readLine());
		
		int clip = 0;
		int emo = 1;
		//clip,emo
		visited = new boolean[1001][1001];

		int time = oper(clip,emo,0);

		System.out.println(time);
	}
	static int oper(int clip,int emo,int time) {
		Queue<Display> q = new LinkedList<>();
		q.add(new Display(clip,emo,time));
		while(!q.isEmpty()) {
			Display d = q.poll();

			if(d.emo == s) {

				return d.time;
			}
			if(visited[d.clip][d.emo])
				continue;
			visited[d.clip][d.emo]=true;
			//copy
			if(d.emo <= 1000) {
				q.add(new Display(d.emo,d.emo,d.time+1));
			}
			//paste
			if(d.clip > 0) {

				if(d.clip+d.emo == s)
					return d.time+1;
				if(d.clip+d.emo < 1000)
					q.add(new Display(d.clip,d.emo+d.clip,d.time+1));
			}
			//del
			if(d.emo > 0) {

				q.add(new Display(d.clip,d.emo-1,d.time+1));
			}
			
		}
		return time;
	}
	
}
class Display{
	int clip;
	int emo;
	int time;
	Display(int clip,int emo,int time){
		this.clip = clip;
		this.emo = emo;
		this.time = time;
	}
	
}

