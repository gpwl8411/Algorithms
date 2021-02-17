package programers;

public class LongestPalindrome {

	static int[] pal;
	static int len;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcdcba";
	
		for(int i=s.length();i>1;i--) {//제일 긴 문자열부터
			
			for(int j=0;j+i<=s.length();j++) {//j~길이만큼
				boolean flag=true;
				
				for(int k=0;k<i/2;k++) {//대칭되는거 같은지 확인
					if(s.charAt(k+j)!=s.charAt(j + i  - k - 1)) {
						flag=false;
						break;
					}
				}
				if(flag) {
					System.out.println(i);
					return;
				}
			}
			
		}
	}
	
}
//다른사람 풀이
//public int solution(String s)
//{
//   int left = 0, right = 0;
//    int result = 1;
//
//    if(s.length() != 1) {
//        for (int center = 1; center < s.length() - 1; center++) {
//            left = center - 1;
//            right = center + 1;
//            while (left >= 0 && right <= s.length() - 1) {
//                if (s.charAt(left) != s.charAt(right))
//                    break;
//
//                result = right - left + 1 > result ? right - left + 1 : result;
//                left--;
//                right++;
//            }
//        }
//
//        for (int center = 0; center <= s.length() - 2; center++) {
//            left = center;
//            right = center + 1;
//            while (left >= 0 && right <= s.length() - 1) {
//                if (s.charAt(left) != s.charAt(right))
//                    break;
//                result = right - left + 1 > result ? right - left + 1 : result;
//                left--;
//                right++;
//            }
//        }
//    }
//
//    return result;
//}
