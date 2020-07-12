package programers;

import java.util.HashSet;
import java.util.stream.Stream;

public class SearchPrime {

	
	static HashSet<Integer> ansSet = new HashSet<>();
	public static void main(String[] args) {
		String numbers = "131";		
		int[] intNumbers = Stream.of(numbers.split("")).mapToInt(Integer::parseInt).toArray();
		
//		for (int i = 1; i <= numbers.length(); i++) {
//				permutation(intNumbers,0,numbers.length(),i);
//		}
		permutation("",numbers,ansSet);
		System.out.println(ansSet.size());

	}
	public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) {
        	System.out.println("prefix = "+prefix);
        	set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++){
        	permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        	System.out.println(prefix + str.charAt(i)+","+ str.substring(0, i) + str.substring(i+1, n));
        }

    }

	static void permutation(int[] arr, int depth, int n, int r) {
		if (depth == r) {
			String checkNum = "";
	    	for (int i = 0; i < r; i++){
	    		checkNum = checkNum+arr[i];
	    	}
	    	if(isPrime(Integer.parseInt(checkNum))){
    			ansSet.add(Integer.parseInt(checkNum));
    		}
	        return ;
	    }
	 
	    for (int i=depth; i<n; i++) {
	        swap(arr, depth, i);
	        permutation(arr, depth + 1, n, r);
	        swap(arr, depth, i);
	    }
	    
	}
	 
	static void swap(int[] arr, int depth, int i) {
	    int temp = arr[depth];
	    arr[depth] = arr[i];
	    arr[i] = temp;
	}

	static boolean isPrime(int num) {
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
