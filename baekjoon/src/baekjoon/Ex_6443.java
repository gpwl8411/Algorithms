package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex_6443{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//백트래킹 애너그램
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String input = br.readLine();
            StringBuilder sb = new StringBuilder();
            char[] arr = new char[input.length()];
            for(int j=0; j<arr.length; j++)
                arr[j] = input.charAt(j);

            Arrays.sort(arr);

            for(int j=0; j<arr.length; j++)
                sb.append(arr[j]);
            sb.append("\n");

            while(next_permutation(arr)) {
                for(int j=0; j<arr.length; j++)
                    sb.append(arr[j]);
                sb.append("\n");
            }

            System.out.print(sb.toString());
		}
	}
	 public static boolean next_permutation(char[] arr) {
	        int i = arr.length-1;

	        while(i>0 && arr[i]<=arr[i-1])
	            i--;                          //앞의 문자보다 뒤에 문자가 사전상 뒤에 오는 경우 탐색

	        if(i<=0) return false;

	        int j = arr.length-1;

	        while(arr[i-1]>=arr[j])
	            j--;                          //선택한 문자보다 사전상 뒤에 오는 문자를 배열 끝에서부터 탐색

	        char temp = arr[j];
	        arr[j] = arr[i-1];
	        arr[i-1] = temp;                //두 문자를 서로 교환

	        j = arr.length-1;
	        while(i<j) {
	            temp = arr[j];
	            arr[j] = arr[i];
	            arr[i] = temp;              //뒤에 문자들 순서를 뒤집어 줌
	            i++;
	            j--;
	        }

	        return true;
	    }
	 //26개 알파벳 조합으로 사용 -> 답 이상
//	static void dfs(int idx, int depth) throws IOException {
//		if (depth == len) {
//			for(int i=0;i<depth;i++)
//				bw.append(output[i]);
//			bw.append("\n");
//			return;
//		}
//		for(int i=0;i<26;i++) {
//			if(alpha[i] > 0) {
//				alpha[i]-=1;
//				output[depth]=(char)('a'+i);
////				System.out.println(output[depth]);
//				dfs(i,depth+1);
//				alpha[depth]+=1;
//			}
//		}
//	}
	 //메모리초과
//	static void perm(String[] arr,boolean[] visited, int r, int depth) throws IOException {
//		if(r==depth) {
//			StringBuilder sb = new StringBuilder();
//			for(int i=0;i<r;i++) {
//				sb.append(arr[i]+"");
//			}
////			sb.append("\n");
//			set.add(sb.toString());
//			return;
//		}
//		
//		for(int i=0;i<r;i++) {
//			if(!visited[i]) {
//				visited[i]=true;
//				arr[depth]=str[i];
//				perm(arr,visited,r,depth+1);
//				visited[i]=false;
//			}
//		}
//	}

}
