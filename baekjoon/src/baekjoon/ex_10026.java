package baekjoon;
import java.util.*;
public class ex_10026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		char[][] arr = new char[num][num];
		int cnt1=0;
		int cnt2=0;
		for(int i=0;i<num;i++){
			String s =input.next();
			for(int j=0;j<num;j++){
				arr[i][j] = s.charAt(j);
			}
		}

		cnt1 = sol(arr,num);
		
		for(int i=0;i<num;i++){
			for(int j=0;j<num;j++){
				if(arr[i][j]=='R'){
					arr[i][j]='G';;
				}
			}
		}
		
		cnt2 = sol(arr,num);
		
		System.out.println(cnt1+" "+cnt2);
	
		
	}
	static int sol(char[][]a , int n){
		int cnt=0;
		boolean visited[][] = new boolean[n][n] ;
		int[] dx={0,0,-1,1};
		int[] dy={-1,1,0,0};
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				char c = a[i][j];
				visited[i][j]=true;
				for (int k=0;k<4;k++){
					int x= i+dx[k];
					int y= j+dy[k];
					
					if(x>=0 && x<n && y>=0 && y<n && !visited[x][y]){
						visited[x][y]=true;
						if(a[x][y]==c){}
					}
					
				}
			}
		}	
		return cnt;
	}

}////////////////////큐를 쓸것, 혹은 재귀함수를 사용할것.
