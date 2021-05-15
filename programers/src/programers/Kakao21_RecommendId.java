package programers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Kakao21_RecommendId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 카카오 블라인드 21 신규 아이디추천
		String new_id = "=.=";
		String answer = "";
		Deque<Character> q = new ArrayDeque<>();
		new_id = new_id.toLowerCase();
		if (new_id.equals("")) {
			answer = "aaa";
			return;
		}
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if (c == '-' || c == '_' || c == '.' || (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
				if (c == '.') {
					if (q.isEmpty())
						continue;
					if (q.peekLast() != '.')
						q.addLast(c);
				} else {
					q.addLast(c);
				}
			}
		}
		while (!q.isEmpty()) {
			if (answer.length() >= 15)
				break;
			answer += q.pollFirst();
		}
		char lastC =  answer.length() > 0 ?answer.charAt(answer.length() - 1) : 'a';
		while (lastC == '.') {
			answer = answer.substring(0, answer.length() - 1);
			lastC = answer.charAt(answer.length() - 1);
		}
		while (answer.length() < 3) {
			answer += answer.length() > 0 ?answer.charAt(answer.length() - 1) : "a";
		}
		System.out.println(answer);
	}

}
/*
 public String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]","");
        System.out.println(temp);
        temp = temp.replaceAll("[.]{2,}",".");
        temp = temp.replaceAll("^[.]|[.]$","");
        System.out.println(temp.length());
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
    }
 */
