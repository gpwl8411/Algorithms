package baekjoon;
import java.util.*;

public class ex_1145_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] num = new int[5];
		int[] array = new int[10];
		
		for(int i = 0; i < 5; i++){
			num[i] = input.nextInt();
		}
		
		Arrays.sort(num);
		
		int temp = num[2];
		out:
		while(true){
			int answer = 0;
			
			for(int i = 0; i < 5; i++){
				if(temp%num[i]==0){
					answer++;
				}
			}
			
			if(answer >= 3){
				System.out.println(temp);
				break out;
			}
			temp++;
		}	
	}
}

