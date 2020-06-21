package baekjoon;
import java.io.*;
import java.util.*;
public class ex_10798 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		char[][] s = new char[5][15];
		String result ="";
		for(int i=0;i<5;i++){
			char[] temp = br.readLine().toCharArray();
			for(int j=0;j<temp.length;j++){
				s[i][j] = temp[j];
			}
			for(int j=temp.length;j<15;j++){
				s[i][j]= ' ';
			}
		}
		
		for(int i=0;i<15;i++){
			for(int j=0;j<5;j++){
				result+=s[j][i];
			}
		}
		System.out.println(result.replaceAll(" ", ""));
		
	}

}
