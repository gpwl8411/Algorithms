package programers;

import java.util.Arrays;
import java.util.Comparator;

public class bignum{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer = "";
		Integer[] numbers = {3,30,34,5,9};
		Arrays.sort(numbers,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String temp1 = o1.toString();
				String temp2 = o2.toString();
				return (temp2+temp1).compareTo(temp1+temp2);
			}			
		});
		
		
		for(int i=0;i<numbers.length;i++){
			answer+=numbers[i];
		}
		if("0".equals(answer.substring(0,1))){
			System.out.println("0");
		}
		
		System.out.println(answer);
	}

}
