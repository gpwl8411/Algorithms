package baekjoon;
import java.util.Scanner;
public class ex_2579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int[] score = new int[n+1];
		int[] max = new int[n+1];
		for(int i=1;i<n+1;i++){
			score[i] = input.nextInt();
		}

			for(int i=1;i<n+1;i++){
				if(i==1){
					max[i] = score[i];
				}else if(i==2){
					max[i] = score[i-1]+score[i];
				
				}else if(i==3){
					max[i] = Math.max(score[i-2], score[i-1]) + score[i];
				}
				else{
				max[i] = Math.max(max[i-2], max[i-3]+score[i-1]) + score[i];
				}
				
			}
	
	System.out.println(max[n]);
	}
}
