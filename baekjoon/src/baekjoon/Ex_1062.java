package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//anta tica -> a c i n t  
public class Ex_1062 {

	static boolean[] alpha = new boolean[26];
	static int n, k;
	static String[] s;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 백트래킹 가르침-비트마스킹도 가능
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		s = new String[n];

		if (k < 5) {
			System.out.println(0);
			return;
		}
		for (int i = 0; i < n; i++) {
			s[i] = br.readLine().replace("anta", "").replace("tica", "");
		}
		alpha['a' - 'a'] = true;
		alpha['n' - 'a'] = true;
		alpha['t' - 'a'] = true;
		alpha['i' - 'a'] = true;
		alpha['c' - 'a'] = true;

		search(1, 0);
		System.out.println(max);

	}

	static void search(int idx, int cnt) {
		if (cnt == k - 5) {
			max = Math.max(max, check());
			return;
		}
		if (idx >= 26) {
			return;
		}
		for (int i = idx; i < 26; i++) {
			if (!alpha[i]) {
				alpha[i] = true;
				search(i + 1, cnt + 1);
				alpha[i] = false;
			}
		}
	}

	static int check() {
		int cnt = 0;

		for (String str : s) {
			boolean flag = true;
			for (int i = 0; i < str.length(); i++) {
				if (!alpha[str.charAt(i) - 'a']) {
					flag = false;
					break;
				}
			}
			if (flag)
				cnt++;
		}

		return cnt;
	}

}
/*
 비트 마스킹 
 public class Main {
    static int n, k, ans = 0;
    static int[] arr;
    static int visited;

    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken()) - 5;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < tmp.length(); j++) {
                arr[i] = arr[i] | (1 << tmp.charAt(j) - 'a');
            }
        }
        if (k < 0) {
            System.out.println(0);
            return;
        }
        visited = visited | 1;
        visited = visited | (1 << ('c' - 'a'));
        visited = visited | (1 << ('i' - 'a'));
        visited = visited | (1 << ('n' - 'a'));
        visited = visited | (1 << ('t' - 'a'));

        dfs(0, 0);
        System.out.println(ans);
    }
    static void dfs(int index, int start) {
        if (index == k) {
            int inner_count = 0;
            for (int now : arr) {
                if ((now & visited) == now) {
                    inner_count += 1;
                }
            }
            ans = Math.max(ans, inner_count);
            return;
        }
        for (int i = start; i < 26; i++) {
            if ((visited & (1 << i)) == (1 << i)) continue;
            visited += (1 << i);
            dfs(index + 1, i + 1);
            visited -= (1 << i);
        }
    }
}
 */
