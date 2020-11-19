package programers;

import java.util.Stack;

public class stack_prices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {2,2,2,1,2};
		int[] answer = new int[prices.length];
        
        for (int i = 0; i < answer.length; i++) {
            for (int j = i+1; j < answer.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j-i;
                    break;
                }
                if (j==answer.length-1) answer[i] = j-i;
            }
        }
        for(int i : answer) {
        	System.out.println(i);
        }
	}

}
