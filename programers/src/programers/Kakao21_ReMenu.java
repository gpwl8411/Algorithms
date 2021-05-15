package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kakao21_ReMenu {

	static List<Character> list;
	static List<String>[] ans;
	static String set;
	static int setCnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 카카오블라인드 21 메뉴 리뉴얼
		String[] orders = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
		int[] course = { 2, 3, 5 };

		list = new ArrayList<>();
		ans = new List[course.length];
		for (int i = 0; i < course.length; i++) {
			ans[i] = new ArrayList<>();
		}
		for (int i = 0; i < orders.length; i++) {
			for (int j = 0; j < orders[i].length(); j++) {
				char c = orders[i].charAt(j);
				if (!list.contains(c))
					list.add(c);
			}
		}
		Collections.sort(list);
		int size = 0;
		for (int i = 0; i < course.length; i++) {
			set = "";
			setCnt = 0;
			comb(new char[course[i]], orders, i, course[i], 0, 0);
			size += ans[i].size();
		}
		String[] answer = new String[size];
		int idx = 0;
		for (int i = 0; i < ans.length; i++) {
			for (String s : ans[i]) {
				answer[idx++] = s;
			}
		}
		Arrays.sort(answer);
		for (String s : answer) {
			System.out.println(s);
		}

	}

	static void comb(char arr[], String[] orders, int idx, int r, int start, int depth) {
		if (r == depth) {
			int cnt = 0;
			for (int i = 0; i < orders.length; i++) {
				boolean check = true;
				for (int j = 0; j < r; j++) {
					if (!orders[i].contains(arr[j] + "")) {
						check = false;
						break;
					}
				}
				if (check && orders[i].length() >= r)
					cnt++;
			}
			if (cnt >= 2) {
				String s = "";
				for (int i = 0; i < r; i++) {
					s += arr[i];
				}
				if (setCnt < cnt) {
					ans[idx].clear();
					ans[idx].add(s);
					setCnt = cnt;
				} else if (setCnt == cnt) {
					ans[idx].add(s);
				}
			}
			return;
		}

		for (int i = start; i < list.size(); i++) {
			arr[depth] = list.get(i);
			comb(arr, orders, idx, r, i + 1, depth + 1);
		}
	}
}
