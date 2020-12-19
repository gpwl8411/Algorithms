package programers;

public class Kakao18_SecretMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=6; 
		int[] arr1 = {46, 33, 33 ,22, 31, 50}; 
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		
		String[] answer = new String[arr1.length];
		
		for(int i=0;i<arr1.length;i++) {
			String str1 = setBinary(arr1[i],n);
			String str2 = setBinary(arr2[i],n);
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<n;j++) {
				if(str1.charAt(j) == '1' || str2.charAt(j) == '1') {
					sb.append("#");
				}else {
					sb.append(" ");
				}
			}
			answer[i] = sb.toString();
		}

		System.out.println(9 | 30);
		
	}
	static String setBinary(int num,int n) {
		StringBuilder sb = new StringBuilder();
		while(num>0) {
			sb.append(String.valueOf(num%2));
			num/=2;
		}
		while(sb.length()<n) {
			sb.append("0");
		}
		
		return sb.reverse().toString();
	}

}
