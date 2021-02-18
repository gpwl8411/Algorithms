package programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Kakao19_Tuple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//2019카카오 개발자 겨울 인턴십
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		
		String[] tmpS = s.split("[}],[{]");
		Map<String,Integer> map = new HashMap<>();
		
		for(int i=0;i<tmpS.length;i++) {
			String str = tmpS[i];
			str = str.replace("{", "");
			str = str.replace("}", "");
			
			String[] tmpStr = str.split(",");
			for(int j=0;j<tmpStr.length;j++) {
				map.put(tmpStr[j], map.getOrDefault(tmpStr[j], 0)+1);
			}
			
		}
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());

		
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// 내림 차순 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		
		int[] answer = new int[map.size()];
		int idx=0;
		for(Entry<String,Integer> entry : list_entries) {
			answer[idx++] = Integer.parseInt(entry.getKey());
		}
		
	}

}
