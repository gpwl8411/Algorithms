package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex_14719 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//빗물 히스토그램 비슷한 문제
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] arr = new int[w];
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<w;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int answer = 0;
		int pre=0;
		//left
		int pivot = arr[0];
		for(int i=0;i<w;i++) {
			if(arr[i] >= pivot) {
				while(!stack.isEmpty()) {
					int index = stack.pop();
					answer += pivot-arr[index];
					pre = index;
				}
				pivot = arr[i];
			}
			else {
				stack.add(i);
			}
		}
		stack.clear();
		//right
		pivot = arr[w-1];
		for(int i=w-1;i>pre;i--) {
			if(arr[i] >= pivot) {
				while(!stack.isEmpty()) {
					int index = stack.pop();
					answer += pivot-arr[index];
				}
				pivot = arr[i];
			}
			else {
				stack.add(i);
			}
		}
		System.out.println(answer);
		
		
	}

}
