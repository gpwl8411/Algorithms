package programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Kakao21_SearchRanking {

	static Map<String,List<Integer>> map = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//카카오 블라인드 21 - 순위검색
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150"
				,"cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250"
				,"- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int[] answer = new int[query.length];
		for(int i=0;i<info.length;i++) {
			String[] str = info[i].split(" ");
			make(str,4,"",0);
		}
		Iterator<String> it= map.keySet().iterator();
        while(it.hasNext()){
            String key=it.next();
            List<Integer> li=map.get(key);
            Collections.sort(li);
        }
		for(int i=0;i<query.length;i++) {
			String[] str= query[i].split(" ");
			String key = "";
			for(int j=0;j<str.length-1;j++) {
				key += str[j];
			}
			key+="and";
			int num = Integer.parseInt(str[str.length-1]);
			answer[i] = search(key,num);
		}
	}
	static int search(String key, int num) {
		if(!map.containsKey(key))
			return 0;
		List<Integer> list = map.get(key);
//		Collections.sort(list);
		int start=0;
		int end=list.size()-1;
		
		while(start<=end){
            int mid=(start+end)/2;
            if(list.get(mid)<num){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
		return list.size()-start ;	
	}
	static void make(String[] arr,int r,String str,int depth) {
		if(r==depth) {

			if(map.containsKey(str)) {
				map.get(str).add(Integer.parseInt(arr[arr.length-1]));
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(Integer.parseInt(arr[arr.length-1]));
				map.put(str, list);
			}
			return;
		}
		make(arr,r,str+"-and",depth+1);
		make(arr,r,str+arr[depth]+"and",depth+1);

	}

}
