package programers;
import java.util.*;
public class stack_top {
	static class top{
		static int height;
		static int seq;
		top(){
			
		}
		top(int height,int seq){
			this.height = height;
			this.seq = seq;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int n = input.nextInt();
		int arr[] = new int[n];
		int answer[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=input.nextInt();
		}
		for(int j=n-1;j>0;j--){
		stack.push(arr[j]);
		System.out.println("push val:"+stack.peek());
		
		
			int m=0;
			while(!stack.isEmpty()){
				if(stack.peek()<arr[j-1]){
			answer[j+m]=j;
			m++;
			stack.pop();
			
			System.out.println();

			
				}
				else{
					break;
				}
		}
		
		
		
		}
		for(int k=0;k<n;k++){
			System.out.println(answer[k]);	
		}
		

	
	}
}
