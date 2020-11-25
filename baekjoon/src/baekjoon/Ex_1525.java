package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_1525 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// bfs 퍼즐
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String puzzle = "";
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				String num = st.nextToken();
				if (num.equals("0"))
					num = "9";
				puzzle += num;

			}
		}
		System.out.println(bfs(puzzle));
		

	}
	static int bfs(String curPuzzle) {
		Map<String,Integer> map = new HashMap<>();
		Queue<String> q = new LinkedList<>();
		q.add(curPuzzle);
		map.put(curPuzzle, 0);
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		while(!q.isEmpty()) {
			String cur = q.poll();
			
			if(cur.equals("123456789")) {
				return map.get(cur);
			}
			int nine = cur.indexOf('9');

			int x = nine / 3;
			int y = nine % 3;
			
			for(int i=0;i<4;i++) {
				int sx = x+dx[i];
				int sy = y+dy[i];
				
				if(sx<0 || sy<0 || sx >= 3 || sy >= 3)
					continue;
				StringBuilder next = new StringBuilder(cur);

				char temp = next.charAt(sx * 3 + sy);
				next.setCharAt(sx * 3 + sy, '9');
				next.setCharAt(nine, temp);
				
				if(!map.containsKey(next.toString())) {
					map.put(next.toString(), map.get(cur)+1);
					q.add(next.toString());
				}
			}
			
		}
		return -1;
	}

}
