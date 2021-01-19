package programers;

import java.util.Arrays;


public class Greedy_Lifeboat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//그리디 구명보트
		int[] people = {70,50,80};
		int limit = 100;
		int answer=0;
		
		Arrays.sort(people);
		
		int left = 0;
		int right = people.length-1;
		
		while(right >= left) {
			int sum = people[right--];
			if(sum+people[left] <= limit)
				left++;
			answer++;
		}
		System.out.println(answer);

	}

}
