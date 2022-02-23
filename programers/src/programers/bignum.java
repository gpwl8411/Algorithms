//package programers;
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//public class BigNum{
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String answer = "";
//		int[] numbers = {3,30,34,5,9};
//		String[] strNum = new String[numbers.length];
//		for(int i=0;i<numbers.length;i++) {
//			strNum[i]=String.valueOf(numbers[i]);
//		}
//		
//		Arrays.sort(strNum, new Comparator<String>() {
//
//			@Override
//			public int compare(String s1, String s2) {
//				return (s2+s1).compareTo(s1+s2);
//			}
//			
//		});
//		for(String i : strNum) {
//			answer+=i;
//		}
//		if(answer.charAt(0)=='0') {
//			answer="0";
//		}
//		
//		System.out.println(answer);
//		
//	}
//	
//
//}
