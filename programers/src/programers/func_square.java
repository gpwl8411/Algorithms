package programers;

import java.util.Scanner;

public class func_square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int w = input.nextInt();
		int h = input.nextInt();
		int cnt = 0;
		for(long i=0;i<w;i++){
			cnt += i*h/w;
		}
		System.out.println(cnt*2);

	}

}
