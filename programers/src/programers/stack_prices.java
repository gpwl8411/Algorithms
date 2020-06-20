package programers;

import java.util.Stack;

public class stack_prices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {2,2,2,1,2};
		int[] answer= new int[prices.length];
		Stack<Integer> stack = new Stack<Integer>();
		int day=0;
		for(int i=0;i<prices.length;i++){
			int p=0;
			stack.push(prices[i]);		
			day++;
			if(i!=prices.length-1 && i!=prices.length-2){
//				System.out.println(stack.peek()+"-"+prices[i+1]);
//				System.out.println(stack.peek() > prices[i+1]);
				while(!stack.isEmpty() && stack.peek() > prices[i+1]){
//					System.out.println("pop"+stack.pop());
					stack.pop();
//					System.out.println(i+":"+(i-p)+":"+(p+1));
					answer[i-p]=p+1;
					p++;
					//System.out.println(answer[i-p]+":"+p);
//					System.out.println(i+":"+p);
				}
			}
			
		}
		int j=prices.length-1;
		while(!stack.isEmpty()){
			if(answer[j]!=0){
				j--;
				day--;
				continue;
			}
			int a = stack.pop();
			answer[j]=prices.length-day;
//			System.out.println(a+";"+answer[j]);
			day--;
			j--;
		}
		for(int i=0;i<prices.length;i++){
			System.out.println(answer[i]);
		}
	}

}
