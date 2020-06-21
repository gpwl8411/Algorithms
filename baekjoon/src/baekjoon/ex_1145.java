package baekjoon;
import java.util.*;
public class ex_1145 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[] multiple= new int[5];
		
                        
        for ( int i=0 ;  i <multiple.length ; i++){
            int in = input.nextInt();
            multiple[i]= in;
        }
        outloop:
        for(int i = 1;;i++){
        	int cnt = 0;
        	for(int j = 0 ; j < 5 ; j++){
        		   if((i%multiple[j]) == 0){
        			   cnt++;
        			   if (cnt >=3){
        				   System.out.println(i);
        				   break outloop;
        			   }
        		   }
        	}
        }

	}
}
