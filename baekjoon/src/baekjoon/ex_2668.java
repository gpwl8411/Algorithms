package baekjoon;
import java.util.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.io.*;
public class ex_2668 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] set = new int[n];
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<n;i++){
			set[i]=input.nextInt();
			if(i>0){
			if(set[i]==i+1){
				sb.append(set[i]);
			}else if(set[set[i]-1]==i+1){
				sb.append(set[i]);
				sb.append(i+1);
			}
		}else{
			if(set[i]==i+1){
				sb.append(set[i]);
			}
		}
			}
		System.out.println(sb.length());
		int[] result = new int[sb.length()];
		for(int i=0;i<sb.length();i++){
			result[i]=Integer.parseInt(sb.charAt(i)+"");
		}
		Arrays.sort(result);
		for(int j=0;j<sb.length();j++){
			System.out.println(result[j]);
		}
	}

}
