package baekjoon;
import java.util.*;
import java.io.*;
public class ex_2251 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		ex_2251 l = new ex_2251();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String str1[] = br.readLine().split(" ");
		int L[] = new int[3];		
		L[0] = Integer.parseInt(str1[0]);
		L[1] = Integer.parseInt(str1[1]);
		L[2] = Integer.parseInt(str1[2]);
		int a = L[0];
		int b = L[1];
		int c = L[2];
		if(l.min(L)==a){
			if(l.max(L)==b){
				System.out.println(0+" ");
				if(Math.abs(c-b)>b){
					
				}
			}else{
				
			}
		}
		else if(l.min(L)==b){
			if(l.max(L)==a){
				
			}else{
				
			}
			
		}else{
			System.out.print(0+" ");
			System.out.print(c);
		}
		
		
		
	}
	public static int max(int n[]) {
	    int max = n[0];

	    for (int i = 1; i < n.length; i++)
	      if (n[i] > max) max = n[i];

	    return max;
	  }
	public static int min(int n[]) {
	    int min = n[0];

	    for (int i = 1; i < n.length; i++)
	      if (n[i] < min) min = n[i];

	    return min;
	  }

}
