package programers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kakao18_zip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="TOBEORNOTTOBEORTOBEORNOT";
//		System.out.println(msg.substring(0, 1));
//		int[] answer={};
		List<Integer> a = new ArrayList<Integer>();
		HashMap<String,Integer> h = new HashMap<String,Integer>();
		for(int i=1;i<='Z';i++){
			h.put( Character.toString((char)('A'+i-1)),i);
		}
//		System.out.println(h.get("Z"));
		int key=27;
		
		for(int i=0;i<msg.length();i++){
			int idx=1;
			for(int j=i;j<idx+i;j++){
				System.out.println("i="+i+",j="+j+",idx="+idx);
				if(j==msg.length()) break;
//				System.out.println(msg.substring(i, j+1));
				if(h.containsKey(msg.substring(i, j+1))){
					
					if(idx+i>=msg.length()){
						a.add(h.get(msg.substring(i, j+1)));
						System.out.println("답에 추가"+msg.substring(i, j+1));
						i=j;
						break;
					}
					idx++;
				}else{
//					System.out.println(msg.substring(i,j));
					a.add(h.get(msg.substring(i, j)));
					h.put(msg.substring(i, j+1), key++);
					System.out.println("답에 추가"+msg.substring(i, j));
					System.out.println("사전에 추가"+msg.substring(i, j+1));
					i=j-1;
					break;
									
				}
			}
		}
		int[] answer = convertIntegers(a);
//		System.out.println(answer.length);

	}
	public static int[] convertIntegers(List<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	        System.out.print(ret[i]+" ");
	    }
	    return ret;
	}

}
