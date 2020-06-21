package baekjoon;
import java.util.*;
public class ex_10805 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int h1 = input.nextInt();
		int w1 = input.nextInt();
		int h2 = input.nextInt();
		int w2 = input.nextInt();
		int cnt = 0;
		double h3 = h1-h2;
		double w3 = w1-w2;
		
		double width = h1*w1 - h2*w2;
		
		while(width >0){
			if(w1 > h3){
				System.out.println(width);
				width = width-Math.pow(h3,2);
				System.out.println(width);
				cnt++;
				width = width-Math.pow(h3,2);
				System.out.println(width);
				cnt++;
				width = width-Math.pow(w3-h2,2);
				System.out.println(width);
				cnt++;
				width = 0;
			
			}else{
				width = width-Math.pow(w1,2);
			}
		}
	}

}
