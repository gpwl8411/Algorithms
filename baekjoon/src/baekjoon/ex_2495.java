package baekjoon;
import java.util.*;
public class ex_2495 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex_2495 num = new ex_2495();
		Scanner input = new Scanner(System.in);
		String num1 = input.nextLine();
		String num2 = input.nextLine();
		String num3 = input.nextLine();
		System.out.println(num.n(num1));
		System.out.println(num.n(num2));
		System.out.println(num.n(num3));

		
	}
	public static int n(String num){
		int cnt=1;
		int max=0;
		String text = " ";
		num = num.concat(text);
		for(int i=0;i<num.length();i++){
			if(i==0) continue;
			else{
				int j = i-1;
				if(num.charAt(i)==num.charAt(j)){
					cnt++;
				}else{
					if(max < cnt){
						max = cnt;
						cnt = 1;
						}
						cnt = 1;
				}
			}
		}
		return max;
	}

}
