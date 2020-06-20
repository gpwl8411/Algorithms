package programers;

import java.util.HashMap;
import java.util.HashSet;

public class kakao19_winter_id {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer=1;
		String[] user_id={"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id={"*rodo", "*rodo", "******"};
		
		int[] id = new int[banned_id.length];
//		ArrayList<String> a = new ArrayList<String>();
//		HashMap<Integer,String> hm = new HashMap<>();
		HashSet<HashSet> hs = new HashSet<>();
		for(int i=0;i<banned_id.length;i++){
			HashSet<String> tmph = new HashSet();
		for(int j=0;j<user_id.length;j++){
				if(user_id[j].length()==banned_id[i].length()){
					if(check(user_id[j],banned_id[i])){
						
					}
						
				}
			}
		}
		for(int i=0;i<id.length;i++){
			answer*=id[i];
		}
		System.out.println(id[0]);
		System.out.println(id[1]);
		System.out.println(id[2]);

	}
	public static boolean check(String uid,String bid){
		for(int i=0;i<uid.length();i++){
				if(uid.charAt(i)!=bid.charAt(i) && bid.charAt(i)!='*')
					return false;
		}
		return true;
	}




}
