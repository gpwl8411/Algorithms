package programers;

import java.util.Arrays;

public class Tri_Snail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//월간 코드 챌린지 시즌 1 삼각 달팽이
		
		int n = 5;
		int len = n*(1+n)/2;
		int[] answer = new int[len];
		int[][] arr = new int[n][n];
//		for(int i=0;i<n;i++) {
//			Arrays.fill(arr[i], -1);
//		}
		int x = -1, y = 0;
		int num =1;
		for(int i=0;i<n;i++) {
			 for(int j = i; j < n; j++) {
				 if (i % 3 == 0) {
	                    x++;
	                } else if (i % 3 == 1) {
	                    y++;
	                } else if (i % 3 == 2) {
	                    x--;
	                    y--;
	                }
	                arr[x][y] = num++;
			 }
		}
		int k = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0) 
                	break;
                answer[k++] = arr[i][j];
            }
        }
//        for(int i : answer) {
//        	System.out.println(i);
//        }

	}

}
