package programers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kakao19_OpenChat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//2019 블라인드 오픈채팅방
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		Map<String,String> map = new HashMap<>();
		
		for(int i=0;i<record.length;i++) {
			String[] str = record[i].split(" ");
			if(str.length > 2)
				map.put(str[1], str[2]);
		}
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<record.length;i++) {
			
			sb.delete(0,sb.length());
			String[] str = record[i].split(" ");
			sb.append(map.get(str[1])+"님이 ");
			
			if(str[0].equals("Enter")) {
				sb.append("들어왔습니다.");
			}
			else if(str[0].equals("Leave")) {
				sb.append("나갔습니다.");
			}
			else continue;
			list.add(sb.toString());
		}
		String[] answer = new String[list.size()];
		list.toArray(answer);

	}

}
