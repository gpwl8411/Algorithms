package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ex_1181 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		String[] arr = new String[num+1];
		for(int i=0;i<=num;i++){
			arr[i] = input.nextLine();
		}
		Arrays.sort(arr, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				Integer o1len = o1.length();
				Integer o2len = o2.length();
				if(o1len == o2len){
					return o1.compareTo(o2);
				}
				return o1len.compareTo(o2len);
			}
			
		});
		for(int i=1;i<=num;i++){
			if(arr[i].equals(arr[i-1]))
				continue;
			System.out.println(arr[i]);
		}
		

	}

}
