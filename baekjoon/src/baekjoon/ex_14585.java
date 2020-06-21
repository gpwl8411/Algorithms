package baekjoon;
import java.util.Scanner;
public class ex_14585 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[][] candy = new int[301][301];
		int[][] eat = new int[301][301];
		
		for(int i=0;i<n;i++){
			int x = input.nextInt();
			int y = input.nextInt();
			candy[x][y] = m;
		}
		eat[0][0] = candy[0][0];
		if(candy[0][1]>0)
			eat[0][1] = eat[0][0]+m-1;
		else if(candy[1][0]>0)
			eat[1][0] = eat[0][0]+m-1;
		else{
			eat[1][0] = eat[0][0];
			eat[0][1] = eat[0][0];
		}
		for(int i=1;i<301;i++){
			for(int j=1;j<301;j++){
				if(candy[i][j]>0 && m-(i+j)>0){
					candy[i][j]=(m-(i+j));				
				}
				eat[i][j] = candy[i][j]+Math.max(eat[i-1][j], eat[i][j-1]);
			}
			
		}
		System.out.println(Math.max(eat[299][300], eat[300][299]));
	}

}
