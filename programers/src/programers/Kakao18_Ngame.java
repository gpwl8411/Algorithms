package programers;


public class Kakao18_Ngame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//카카오 블라인드 18 n진수 게임
		
		int n = 16;
		int t = 16;
		int m = 2; 
		int p = 2;
		
		StringBuilder sb = new StringBuilder();
		
		int num = 0;
		String answer = "";
		while(sb.length() < m*t) {
			String result = baseN(n,num++);
			sb.append(result);
		}
		int idx=p-1;
		for(int i=0;i<sb.length();i++) {
			if(answer.length()==t)
				break;
			if(i==idx) {
				answer+=sb.substring(i, i+1);
				idx+=m;
			}
		}
		System.out.println(answer);
		
	}
	static String baseN(int n,int num) {
		StringBuilder sb = new StringBuilder();
		if(num==0)
			return "0";
		
		while(num > 0) {
			if(num%n >= 10) {
				sb.append((char)(num%n+55)+"");
			}
			else {
				
				sb.append(num%n);
			}
			num/=n;
		}
		
		return sb.reverse().toString();
	}

}
