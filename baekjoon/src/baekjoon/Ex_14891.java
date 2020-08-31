package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_14891 {
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[4][8];
		int score=0;
		for(int i=0;i<4;i++) {
			String[] str = br.readLine().split("");
			for(int j=0;j<str.length;j++) {
				map[i][j]=Integer.parseInt(str[j]);
			}
		}

		int n = Integer.parseInt(br.readLine());
//		ArrayList<int[]> list = new ArrayList<>();
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int wheel = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			int tmpDir = dir;
			boolean[][] flag = new boolean[4][4];
			for(int j=1;j<3;j++) {
				
				if(map[j][6]!= map[j-1][2]){
					flag[j-1][j]=true;
					flag[j][j-1]=true;
				}
				
				if(map[j][2]!= map[j+1][6]) {
					flag[j][j+1]=true;
					flag[j+1][j]=true;
				}
			}

			for(int j=wheel;j<4;j++) {
				if(j!=3) {
					if(flag[j][j+1])
						rotate(j+1,-tmpDir);
					else
						break;
				}else {
					break;
				}
				tmpDir*=-1;
			}
			tmpDir=dir;
			for(int j=wheel;j>0;j--) {
				if(flag[j][j-1])
					rotate(j-1,-tmpDir);
				else
					break;
				tmpDir*=-1;
			}
			rotate(wheel,dir);
			
			
		}
		for(int i=0;i<4;i++) {
			score+=map[i][0]*(Math.pow(2, i));
		}
		System.out.println(score);
		
	}
	static void rotate(int wheel,int dir) {
		int size=map[0].length;
		int[] temp = new int[size];
		if(dir==1) {
			for(int i=0;i<size;i++) {
				temp[(i+1)%size]=map[wheel][i];
			}
		}else {
			for(int i=1;i<=size;i++) {
				temp[(i-1)%size]=map[wheel][i%size];
			}
		}
		for(int i=0;i<temp.length;i++) {
			map[wheel][i]=temp[i];
		}

	}



}
