package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_1226 {

	static int[][] map = new int[16][16];;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int T;
//		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= 10; test_case++)
		{
//			System.out.println(T);
			String t = br.readLine();
			int x=0;
			int y=0;
			for(int i=0;i<16;i++) {
//				String[] str = br.readLine().split("");
				String s = br.readLine();
				String[] str= s.split("");
				for(int j=0;j<16;j++) {
					map[i][j] = Integer.parseInt(str[j]);
					if(map[i][j]==2) {
						x = i;
						y = j;
					}
				}
			}
			bw.append("#"+t+" "+bfs(x,y)+"\n");
		}
		bw.flush();
	}
	static int bfs(int x,int y) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		boolean[][] visited = new boolean[16][16];
		Queue<int[]> q =new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] idx = q.poll();
			visited[idx[0]][idx[1]]=true;
			 for(int i=0;i<4;i++) {
				 int sx = idx[0]+dx[i];
				 int sy = idx[1]+dy[i];
				 
				 if(sx < 0 || sy < 0 || sx >= 16 || sy >= 16)
					 continue;
				 if(map[sx][sy]==3)
					 return 1;
				 if(!visited[sx][sy] && map[sx][sy]==0)
					 q.add(new int[] {sx,sy});
			 }
		}
		return 0;
	}
	/**
	 * 1
1111111111111111
1210000000100011
1010101110101111
1000100010100011
1111111010101011
1000000010101011
1011111110111011
1010000010001011
1010101111101011
1010100010001011
1010111010111011
1010001000100011
1011101111101011
1000100000001311
1111111111111111
1111111111111111
	 */

}
