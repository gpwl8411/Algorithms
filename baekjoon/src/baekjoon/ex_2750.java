package baekjoon;
import java.util.*;
public class ex_2750 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int in=0;
		in = sc.nextInt();
		int[] s = new int[in];
		for (int i =0; i<s.length;i++){	
			s[i]=sc.nextInt();			
		}
		for (int i =0; i<s.length;i++){		
			for(int j=i+1;j<s.length;j++){
				if(s[i] > s[j]){
					int temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
				
				
			}
			
		}
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}

}
	}
