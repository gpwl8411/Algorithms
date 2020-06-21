package baekjoon;
import java.util.Scanner;
public class ex_1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int home[][] = new int[n][3];
		int price[][] = new int[n][3];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<3;j++){
				home[i][j] = input.nextInt();
			}
		}
		price[0][0] = home[0][0];
		price[0][1] = home[0][1];
		price[0][2] = home[0][2];
		for(int i=1;i<n;i++){
			price[i][0] = Math.min(price[i-1][1], price[i-1][2])+home[i][0];
		    price[i][1] = Math.min(price[i-1][0], price[i-1][2])+home[i][1];
		    price[i][2] = Math.min(price[i-1][0], price[i-1][1])+home[i][2];
		}
		
		System.out.println(Math.min(Math.min(price[n-1][0],price[n-1][1]),price[n-1][2]));
		
		
		
	}

}
