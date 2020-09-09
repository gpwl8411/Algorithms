package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ex_5375 {
	//윗면 U-w
	//아랫면 D-y
	//앞면 F-r
	//뒷면 B-o
	//왼쪽면 L-g
	//오른쪽면 R-b
	//시계방향 +
	//반시계 -
	static String[][][] cube;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		cube = new String[6][3][3];
		
 		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int ways = Integer.parseInt(st.nextToken());
			for(int j=0;j<ways;j++) {
				String str = st.nextToken();
				rotate(str);
			}
			bw.append("");
		}
		
	}
	static void rotate(String str) {
		char side = str.charAt(0);
		char dir = str.charAt(1);
		switch(side) {
		case 'U': break;
		case 'D': break;
		case 'F': break;
		case 'B': break;
		case 'L': break;
		case 'R': break;
		}
	}

}
