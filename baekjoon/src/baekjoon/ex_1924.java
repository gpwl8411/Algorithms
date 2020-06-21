package baekjoon;
import java.util.*;
public class ex_1924 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String day1[] = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
		
		int mon[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		Scanner day = new Scanner(System.in);
		int x = day.nextInt() ;
		int y = day.nextInt() ;
		int sum = 0;
		
		for (int i =0;i < x-1;i++){
			sum += mon[i];
		}
		sum += y;
		sum = sum%7;
		if (sum==0){
			System.out.println(day1[6]);
		}
		else{
			System.out.println(day1[sum-1]);}
		day.close();
	}

}
