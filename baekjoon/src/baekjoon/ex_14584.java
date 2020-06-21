package baekjoon;
import java.util.Scanner;
public class ex_14584 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		int n = input.nextInt();
		String[] str = new String[n];
		for(int i=0;i<n;i++){
			str[i]=input.next();
		}
		int cnt = 0;
		
		out:
		for(int i=0;i<n;i++){
			for(int k=0;k<26;k++){
				if(s.contains(str[i])) {break out;}
				else{
					cnt=0;
					for(int j=0;j<str[i].length();j++){
						str[i].replace(s.charAt(j), (char)((int)s.charAt(j)+1));
					}
					cnt++;
					
				}
			}
		}
		
		for(int i=0;i<s.length();i++){
			s.replace(s.charAt(i), (char)((int)s.charAt(i)+cnt));
//			System.out.println(cnt);
		}
		System.out.println("");
		System.out.println(s);
	}

}
