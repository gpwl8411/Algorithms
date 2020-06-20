package programers;

import java.util.Arrays;

public class sort_hindex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {22,27};
		
		Arrays.sort(n);
		
		
		for(int i=0;i<n.length;i++){
			int h=n.length-i;
			if(h<=n[i]){
				System.out.println(h);
				break;
			}
		}
	}

}
