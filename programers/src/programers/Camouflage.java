package programers;

import java.util.ArrayList;
import java.util.HashMap;

public class Camouflage {

	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		HashMap<String, ArrayList<String>> map = new HashMap<>();
		int answer = 0;

		for (int i = 0; i < clothes.length; i++) {
			ArrayList<String> list;
			if (map.containsKey(clothes[i][1])) {
				list = map.get(clothes[i][1]);

			} else {
				list = new ArrayList<>();
			}
			list.add(clothes[i][0]);
			map.put(clothes[i][1], list);
			answer++;
		}
//		int typeCnt1 = 1;
//		int typeCnt2 = 1;
//		for (String key : map.keySet()) {
//			if(map.size()==1){
//				typeCnt1 = 0;
//				typeCnt2 = 0;
//				break;
//			}
//			for(String key2 : map.keySet()){
//				for(int i=1;i<=map.size();i++){
//					
//				}
//				if(!key.equals(key2))
//				typeCnt1 += map.get(key).size()*map.get(key2).size();
//			}
//			if(map.size()==2) typeCnt2=0;
//			typeCnt2 *= map.get(key).size();
//		}
		System.out.println(answer);

	}
//	private static int combination(ArrayList<String> comArr, int n, int r, int index,String target) {
//        if(r==0){
//            for(String i : comArr){
//                System.out.print(i+" ");
//            }
//            System.out.println();
//            return;
//        }
//        if(target == n)return;
//         
//        comArr.add(index, target); 
//        combination(comArr, n, r-1, index+1, target+1);//»Ì´Â°æ¿ì
//        combination(comArr, n, r, index, target+1);//¾È»Ì´Â°æ¿ì
//         
//    }

}
