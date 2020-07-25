package programers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class N {

	static HashSet<Integer>[] dp = new HashSet[9];
	public static void main(String args[]) {
		int n = 5; 
		int number = 12;
		if(n==number) {
			System.out.println(1);
		}
		String n_ = String.valueOf(n);
		for(int i=0;i<=8;i++) {
			dp[i] = new HashSet<Integer>();
			if(i==1) dp[1].add(Integer.parseInt(n_));
			if(i<2 ) continue;
			n_+=String.valueOf(n);
			dp[i].add(Integer.parseInt(n_));
			for(int j=1;j<i;j++) {
				 calc(j,i);
				 if(dp[i].contains(number)) {
					 System.out.println(i);
					 
				 }
				
				
			}
		}
		System.out.println(-1);
	}
	static void calc(int a,int b) {

		Iterator<Integer> listA = dp[a].iterator();
		Iterator<Integer> listB = dp[b-a].iterator();
		
		while(listA.hasNext()) {
			int numA = listA.next();

			while(listB.hasNext()) {
				int numB = listB.next();
				dp[b].add(numA+numB);
				dp[b].add(numA-numB);
				dp[b].add(numA*numB);
				if(numB!=0)
				dp[b].add(numA/numB);
			
			}
			listB = dp[b-a].iterator();
		}
	}
		
}
