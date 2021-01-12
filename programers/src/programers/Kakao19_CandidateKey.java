package programers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Kakao19_CandidateKey {

	static Map<String,HashSet> map;
	static List<String> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 카카오2019 블라인드 후보키
		String[][] relation = { { "1", "a", "11", "a" }, { "1", "b", "11", "b" }, { "2", "a", "22", "a" },
				{ "2", "b", "22", "b" } };
		map = new HashMap<>();
		list = new ArrayList<>();
		int n = relation[0].length;
		for(int i=0;i<relation[0].length;i++) {
			combination(relation,new int[n],new boolean[n],0,n,i);
		}
		System.out.println(list.size());
	}
	static void combination(String[][] relation,int[] arr,boolean[] visited,int start,int n,int r) {
		if(r == 0) {
			String key="";
	        for(int i=0;i<n;i++){ 
	        	if(visited[i])
	        	key+=String.valueOf(i);
	        }
	        map.put(key, new HashSet());
	        for(int i=0;i<relation.length;i++) {
	        	String val="";
	        	for(int j=0;j<n;j++){ 
		        	if(visited[j])
		        	val+=String.valueOf(relation[i][j]);
		        }
	        	map.get(key).add(val);
	        }
	        if(map.get(key).size()==relation.length) {	        	
	        	for(String s : list) {
	        		int keyLen = s.length();
	        		for(int i=0;i<n;i++){ 
	    	        	if(visited[i] && s.contains(String.valueOf(i))) {
	    	        		keyLen--;
	    	        	}
	    	        }
	        		if(keyLen==0) {
	        			return;
	        		}
	        	}
	        	list.add(key);
	        }
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(relation,arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	//비트 마스킹 이용
//	public int solution(String[][] relation) {
//		ArrayList<Integer> candidateKey = new ArrayList<>();
//		
//		int rowLen = relation.length;
//		int colLen = relation[0].length;
//		
//		for(int set = 1 ; set < (1 << colLen) ; set++) {
//			// 최소성 검사 
//			if(!isMinimal(set, candidateKey)) continue;
//			
//			// 유일성 검사 
//			if(isUnique(set, rowLen, colLen, candidateKey, relation)) {
//				System.out.println(Integer.toBinaryString(set));
//				candidateKey.add(set);
//			}
//		}
//		
//		return candidateKey.size();
//	}
//
//	private boolean isUnique(int set, int rowLen, int colLen, ArrayList<Integer> candidateKey, String[][] relation) {
//		HashMap<String, String> map = new HashMap<>();
//		
//		for(int row = 0 ; row < rowLen ; ++row) {
//			String dataByKeySet = "";
//			
//			for(int th = 0 ; th < colLen ; ++th) {
//				if((set & (1 << th)) != 0) {
//					dataByKeySet += relation[row][th];
//				}
//			}
//			
//			if(map.containsKey(dataByKeySet)) return false;
//			else map.put(dataByKeySet, dataByKeySet);
//		}
//		
//		return true;
//	}
//
//	private boolean isMinimal(int set, ArrayList<Integer> candidateKey) {
//		for(int key : candidateKey) {
//			if((key & set) == key) return false;
//		}
//		
//		return true;
//	}
}