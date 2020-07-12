package programers;

import java.util.Arrays;
import java.util.Comparator;

public class BigNum{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer = "";
		Integer[] numbers = {3,30,34,5,9};
		
		Arrays.sort(numbers, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = String.valueOf(o1);
				String s2 = String.valueOf(o2);
				return (s2+s1).compareTo(s1+s2);
			}
			
		});
		for(int i : numbers) {
			answer+=i;
		}
		if(answer.charAt(0)=='0') {
			answer="0";
		}
		
		System.out.println(answer);
		
	}
	

}
