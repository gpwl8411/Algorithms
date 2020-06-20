package programers;

public class TargetNum {

	static int cnt;
	public static void main(String[] args) {

		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		dfs(0, 0,numbers,target);
		
		System.out.println(cnt);

	}

	public static void dfs(int idx, int sum,int[] numbers,int target) {
		
		if(idx==numbers.length){
			if(sum==target) cnt++;
			return;

		}
	
			dfs(idx+1, sum + numbers[idx], numbers,target);
			dfs(idx+1, sum - numbers[idx],numbers,target);
	}

}
