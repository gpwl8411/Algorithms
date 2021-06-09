package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Ex_16637 {

	static int max = Integer.MIN_VALUE;
	static int[] num;
	static char[] op;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 삼성 a형 기출 - 괄호 추가하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		num = new int[n / 2 + 1];
		op = new char[n / 2];
		String s = br.readLine();
		int idxNum = 0;
		int idxOp = 0;

		for (int i = 1; i <= n; i++) {
			char c = s.charAt(i - 1);
			if (i % 2 == 0) {
				op[idxOp++] = c;
			} else {
				num[idxNum++] = c-'0';
			}
		}
		for (int i = 0; i <= (n + 1) / 4; i++) {
			comb(0, '+', 0, i, 0);
		}
		System.out.println(max);
	}

	static void comb(int sum, char preOp, int idx, int r, int depth) {
		if (depth == r) {
			for (int i = idx; i < num.length; i++) {
				if(i==idx)
					sum = calc(preOp,sum,num[idx]);
				else
					sum = calc(op[i-1],sum,num[i]);
			}
			max =Math.max(max, sum);
			return;
		}
		if (idx >= num.length)
			return;
		if (idx != num.length - 1) {
			int tmp = calc(op[idx], num[idx], num[idx + 1]);// 괄호생성
			if(idx+1 < op.length)
				comb(calc(preOp, sum, tmp), op[idx + 1], idx + 2, r, depth + 1);
			else
				comb(calc(preOp, sum, tmp), '+', idx + 2, r, depth + 1);
		}
		if(idx < op.length)
		comb(calc(preOp, sum, num[idx]), op[idx], idx + 1, r, depth);// 괄호 아닐때

	}

	static int calc(char op, int n1, int n2) {
		int ans = 0;
		switch (op) {
		case '+':
			ans = n1 + n2;
			break;
		case '-':
			ans = n1 - n2;
			break;
		case '*':
			ans = n1 * n2;
			break;
		}
		return ans;
	}
}
