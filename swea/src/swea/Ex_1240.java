package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_1240 {

	static String[] code = {"0001101","0011001","0010011","0111101","0100011"
			,"0110001","0101111","0111011","0110111","0001011"};
	static String[] input = new String[8];
	public static void main(String args[]) throws Exception {
		// 단순2진 암호코드
		/*
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다. 여러분이 작성한 코드를
		 * 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때
		 * 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다. 따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		 * 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		// System.setIn(new FileInputStream("res/input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
//		Scanner sc = new Scanner(System.in);
//		int T;
//		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			boolean flag = false;

			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				if (!flag) {
					for (int j = m - 1; j >= 0; j--) {
						if (s.charAt(j) == '1') {
							flag = true;
							fillCode(s, j);
							break;
						}
					}
				}
			}
			bw.append("#" + test_case + " " + calc()+"\n");
		}
		bw.flush();
	}

	static int calc() {
		int oddSum = 0;
		int totalSum = 0;
		int ans = 0;
		ArrayList<String> list = new ArrayList<String> (Arrays.asList(code));
		for(int i=0;i<input.length;i++) {
			int num = list.indexOf(input[i]);
			if((i+1)%2==1) {
				oddSum+=num;
			}else {
				totalSum+=num;
			}
			ans+=num;
		}
		totalSum += oddSum*3;
		return totalSum%10==0 ? ans : 0 ;
	}

	static void fillCode(String s, int idx) {
		for (int i = input.length - 1; i >= 0; i--) {
			input[i] = s.substring(idx-6,idx+1);
			idx = idx-7;
		}
	}

}
