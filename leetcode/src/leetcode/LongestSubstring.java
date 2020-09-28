package leetcode;

public class LongestSubstring {

	public static void main(String[] args) {
		String s = "pwwkew";
		//가장 긴 중복없는 부분문자열
		int start=0;
		int end=1;
		int max = Integer.MIN_VALUE;
		if(s.length()==0)
            System.out.println(0);
        if(s.length()==1)
            System.out.println(1);
		String str=s.substring(0,1);
		while(true) {
			if(end>=s.length()) break;
			if(str.contains(s.charAt(end)+"")) {
				start++;
				max = Math.max(max,str.length() );
				str = s.substring(start, end);
			}else {
				str += s.charAt(end);
				max = Math.max(max,str.length() );
				end++;
			}
			
		}
//		System.out.println(str);
		System.out.println(max);
//		System.out.println("bbbb".contains(s.charAt(0)+""));
		
	}

}
