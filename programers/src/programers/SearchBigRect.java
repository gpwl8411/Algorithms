package programers;

import java.util.Arrays;

public class SearchBigRect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//프로그래머스 가장 큰 정사각형 찾기
		int[][] board= {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int[][] map = new int[board.length+1][board[0].length+1];
		
		int max = 0;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				map[i+1][j+1] = board[i][j];
			}
		}
		for(int i=1;i<=board.length;i++) {
			for(int j=1;j<=board[0].length;j++) {
				if(map[i][j]!=0)
					map[i][j] = Math.min(map[i-1][j], Math.min(map[i-1][j-1], map[i][j-1]))+1;
				max = Math.max(max, map[i][j]);
			}
		}

		
		System.out.println(max*max);
	}

}
