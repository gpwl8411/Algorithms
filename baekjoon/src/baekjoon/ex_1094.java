package baekjoon;
import java.util.*;
public class ex_1094 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int x =input.nextInt();
		int init = 64;
		int cnt = 0;
		int sum = 0;
		
		while(x>0){
			if(init > x){
				init /=2;
			}else{
				cnt++;
				x -= init;
			}
		}
		System.out.println(cnt);

	}



	

}
