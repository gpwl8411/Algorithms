package programers;

import java.util.HashSet;

public class SearchPrime {

	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		String numbers = "131";
		boolean[] visited = new boolean[numbers.length()];
		System.out.println("start");
		for (int i = 1; i <= numbers.length(); i++) {
				
				comb(numbers, visited, "", 0, numbers.length(), i, 0);
		}
		for(int s : set){
//			System.out.println(s);
		}
		System.out.println(set.size());

	}

	public static void comb(String numbers, boolean[] visited, String num, int start, int n, int r, int cnt) {
		if (cnt == n+1)
			return;
		if (r == 0) {
			String reverse = new StringBuilder(num).reverse().toString();
			int number = Integer.parseInt(num);
			int revNumber = Integer.parseInt(reverse);
			if (prime(number)) {
				set.add(number);
			}
			if (prime(revNumber)) {
				set.add(revNumber);
			}
			System.out.println(number);
			System.out.println(revNumber);
			return;
		}

		start %= numbers.length();
		for (int i = start; i < n; i++) {
			if (visited[i])
				continue;
			String tmp = num;
			comb(numbers, visited, num, i + 1, n, r, cnt + 1);
			num += numbers.charAt(i);
			visited[i] = true;
			comb(numbers, visited, num, i + 1, n, r - 1, cnt + 1);
			num = tmp;
			visited[i] = false;
		}
		for (int i = start; i > 0 ; i--) {
			if (visited[i])
				continue;
			String tmp = num;
			comb(numbers, visited, num, i - 1, n, r, cnt + 1);
			num += numbers.charAt(i);
			visited[i] = true;
			comb(numbers, visited, num, i - 1, n, r - 1, cnt + 1);
			num = tmp;
			visited[i] = false;
		}
		return;

	}

	public static boolean prime(int num) {
		if (num == 1 || num == 0)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num != 2 && num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
