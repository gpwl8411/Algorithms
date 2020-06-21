package baekjoon;
import java.util.Scanner;
public class ex_11778 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		int r=1;
	
		n1=fibo(n1);
		n2=fibo(n2);

		if(n1>n2){
			while(r>0){
				r=n1%n2;
				n1=n2;
				n2=r;
			}
		}else{
			while(r>0){
				r=n2%n1;
				n2=n1;
				n1=r;
				
			}
		}
		System.out.println(n1);
		
		
	}
	public static int fibo(int n){
		if (n <= 1)
			return n;
		else 
			return fibo(n-2) + fibo(n-1);

	}

}
