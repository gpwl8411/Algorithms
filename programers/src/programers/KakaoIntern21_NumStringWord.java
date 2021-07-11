package programers;

import java.util.Arrays;
import java.util.List;

public class KakaoIntern21_NumStringWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//카카오인턴21 숫자 문자열과 영단어
		String s = "23four5six7";
		String[] num = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		List<String> numList = Arrays.asList(num);
		StringBuilder ans = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>='0' && s.charAt(i)<='9') {
				ans.append(s.charAt(i));
				continue;
			}
			sb.append(s.charAt(i));
			int idx = numList.indexOf(sb.toString());
			if(idx!=-1) {
				ans.append(idx);
				sb.setLength(0);
			}
			
		}
		System.out.println(Integer.parseInt(ans.toString()));
	}

}
