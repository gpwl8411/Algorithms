package programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Num124 {

	public static void main(String[] args) {

		//124 나라의 숫자
		int n=14;
		String answer = "";
		String[] numbers = {"4","1","2"};
		while(n!=0) {
			int remainder = n%3;
			n/=3;
			
			if(remainder == 0) n--;
			
			answer = numbers[remainder] + answer;
		}
		System.out.println(answer);
		
		
	}

}
