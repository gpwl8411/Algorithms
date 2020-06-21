package baekjoon;
import java.util.Scanner;
public class ex_14915 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		
		String change = "";
        String temp = "";

        if(m==0) change = Integer.toString(0);
        while(m > 0){
            if( (m % n) < 10 ) {
                change = (m % n) + change;
                m /= n;
            }
            else {
                String temp1 = (char)((m % n) + 55)+"";
                change = temp1 + change;
                m /= n;
            }

        }
        
		System.out.println(change);
	}

}
