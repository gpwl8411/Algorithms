package baekjoon;
import java.util.*;
import java.io.*;
public class ex_6603 {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	private static int arr[]; 
	private static int cnt = 0;


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		while (true) { 
			String str1[] = br.readLine().split(" "); 
		int N = Integer.parseInt(str1[0]); 
		if (N == 0) break; 
		arr = new int[N]; 
		for (int i = 0; i < N; i++) { 
			arr[i] = Integer.parseInt(str1[i + 1]); 
			} 
		Arrays.sort(arr); 
		dfs(0, 6, ""); 
		bw.write("\n"); 
		} 
		bw.flush();

		
			
		}
	private static void dfs (int start, int N, String str) throws IOException { 
		if (N == 0) { 
			bw.write(str); 
			bw.write("\n"); 
			return; } 
		if (start == arr.length) return; 
		dfs(start + 1, N - 1, str + arr[start] + " "); 
		dfs(start + 1, N, str); 
		}

	
		
	}
	


