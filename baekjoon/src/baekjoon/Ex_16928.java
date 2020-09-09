package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_16928 {
	static int[][] map;
	
//	static char[][] mapSL;
	public static void main(String[] args) throws Exception{
		map = new int[10][10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int snake = Integer.parseInt(st.nextToken());
		int ladder = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<snake+ladder;i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int row = num1>=10 ? num1%10==0 ? num1/10-1 : num1/10 : 0;
			int col = num1>=10 ? num1%10==0 ? 9 :num1%10-1 : num1-1;
			map[row][col] =num2;
			
		}
		print(map);
		System.out.println(bfs(new Token(1,0)));
		
		
		
	}
	static int bfs(Token t) {
		boolean[][] visited = new boolean[map.length][map.length];
		Queue<Token> q = new LinkedList<>();
		q.add(t);
		visited[0][0]=true;
		while(!q.isEmpty()) {
			Token token = q.poll();
			for(int i=1;i<=6;i++) {
				int num = token.num+i;
				int sx = num>=10 ? num%10==0 ? num/10-1 : num/10 : 0;
				int sy = num>=10 ? num%10==0 ? 9 :num%10-1 : num-1;
				if(sx < 0  || sy < 0 || sx >=map.length || sy >= map.length) {
					continue;
				}
				if(visited[sx][sy]) {
					continue;
				}
				if(num==100)
					return token.cnt+1;
				if(map[sx][sy]!=0) {
					num=map[sx][sy];
				}
				visited[sx][sy]=true;
				q.add(new Token(num,token.cnt+1));
				
			}
		}
		return 0;
	}
	static void print(int[][] map) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
class Token{

	int cnt;
	int num;
	Token(int num,int cnt){

		this.cnt = cnt;
		this.num = num;
	}
}
