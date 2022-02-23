package programers;

import java.util.*;
public class Kakao22_Report {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// kakao 블라인드 22 신고 결과 받기
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		Map<String,Set<String>> reportMap = new HashMap<>();
		int[] answer = new int[id_list.length];
		
		for(int i=0; i<report.length; i++) {
			String[] arr = report[i].split(" ");
			String reporter = arr[0];
			String reportedUser = arr[1];
			
			if(!reportMap.containsKey(reportedUser)) {
				Set<String> set = new HashSet<>();
				set.add(reporter);
				reportMap.put(reportedUser,set);
			}else {
				reportMap.get(reportedUser).add(reporter);
			}
		}
		
		List<String> idIdxList= Arrays.asList(id_list);
		for(String key : reportMap.keySet()) {
			if(reportMap.get(key).size() >= k) {
				for(String user : reportMap.get(key)) {
					answer[idIdxList.indexOf(user)]+=1;
				}
			}
		}
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
	}

}
