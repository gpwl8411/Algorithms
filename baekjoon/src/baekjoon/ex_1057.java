package baekjoon;
import java.util.*;
public class ex_1057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int kim = input.nextInt();
		int lim = input.nextInt();
		for(int i=1;i<n;i++){
			if(kim<lim && kim%2!=0){
				if(lim == kim+1){
					System.out.println(i);
					break;
				}
			}
			else if(lim<kim && lim%2!=0){
				if(kim == lim+1){
					System.out.println(i);
					break;
				}
			}
			if(kim%2==0){
				kim /=2;
				
			}else{
				kim += 1;
				kim /= 2;
				}
			if(lim%2==0){
				lim /=2;
					
			}else{
				lim += 1;
				lim /= 2;
				
			}
		}
	}

	}
