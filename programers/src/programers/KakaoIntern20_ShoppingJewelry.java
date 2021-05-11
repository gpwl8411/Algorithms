package programers;

import java.util.HashMap;

public class KakaoIntern20_ShoppingJewelry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//카카오 인턴십 20 보석 쇼핑
		String[] gems= {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		HashMap<String,Integer> map = new HashMap<>();
		int[] answer = new int[2];
		
		for(int i=0;i<gems.length;i++) {
			String jewelry = gems[i];
			map.put(jewelry, 0);
		}
		int size = map.size();
		if(size==1) {
			answer[0]=1;
			answer[1]=1;
			return;
		}
		int ans = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		int cnt=0;
		
		while(left <= right) {

			if(cnt == size) {
				int dis = right-left+1;
				if(ans > dis) {
					ans = dis;
					answer[0] = left+1;
					answer[1] = right+1;
				}
				int num = map.get(gems[left])-1;
				if(num==0) 
					cnt--;
				map.put(gems[left], num);
				left++;
			}
			else{
				if(map.get(gems[right])==0) {
					map.put(gems[right], 1);
					cnt++;
				}
				right++;
				if(right >= gems.length)
					break;
				int num = map.get(gems[right])+1;
				if(num==1)
					cnt++;
				map.put(gems[right], num);
			}
		}
		
		System.out.println(answer[0]+","+answer[1]);
	}

}
