package programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MockExam {

	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2 };
		ArrayList<CorrectIndex> ans = new ArrayList<>();
		ArrayList<CorrectIndex> copy = new ArrayList<>();
		int[] stu1 = { 1, 2, 3, 4, 5 };
		int[] stu2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] stu3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		CorrectIndex ci1 = new CorrectIndex(1, 0);
		CorrectIndex ci2 = new CorrectIndex(2, 0);
		CorrectIndex ci3 = new CorrectIndex(3, 0);

		for (int j = 0; j < answers.length; j++) {
			if (stu1[j % stu1.length] == answers[j]) {
				ci1.sum++;
			}
			if (stu2[j % stu2.length] == answers[j]) {
				ci2.sum++;
			}
			if (stu3[j % stu3.length] == answers[j]) {
				ci3.sum++;
			}
		}

		ans.add(ci1);
		ans.add(ci2);
		ans.add(ci3);

		Collections.sort(ans, new Comparator<CorrectIndex>() {

			@Override
			public int compare(CorrectIndex o1, CorrectIndex o2) {
				return Integer.compare(o2.sum, o1.sum);
			}
		});
		int max = ans.get(0).sum;
		for (CorrectIndex i : ans) {
			if (max == i.sum){
				copy.add(i);
			}
		}
		int[] answer = new int[copy.size()];
		int idx=0;
		for(CorrectIndex a : copy){
			answer[idx++]=a.index;
		}
	}
	

}
class CorrectIndex {
	int index;
	int sum;

	CorrectIndex(int index, int sum) {
		this.index = index;
		this.sum = sum;
	}
}
