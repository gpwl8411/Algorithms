package programers;

public class Greedy_MakeBigNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 그리디 큰 수 만들기
		String number = "4177252841";
		int k = 4;
		
		int left = 0;
		StringBuilder answer = new StringBuilder();

		for(int i=0;i<number.length()-k;i++) {
			char max = '0';
			for(int j=left; j<=i+k; j++) {
				if(max < number.charAt(j)) {
					max = number.charAt(j);
					left = j+1;
				}
			}
			answer.append(max);
		}
		
		System.out.println(answer);
	}

}
