package baekjoon;
import java.lang.reflect.Array;
import java.util.*;
public class ex_2309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for (int i=0;i<9;i++){
			arr.add(input.nextInt());
		}
		Collections.sort(arr);
		 int sum = 0;
		 int n_i = -1;
	     int n_j = -1;
	         
	      
	 
	        for(int i = 0; i < 9; i++)   {
	            for(int j = 0; j < 9; j++)   {
	                if(i==j)    {
	                    continue;
	                }
	                for(int k = 0; k < 9; k++)   {
	                    if(k == i || k == j)    {
	                        continue;
	                    }else   {
	                        sum = sum + arr.get(k);
	                    }
	                }
	                if(n_i >= 0)   {
		                break;
		            }
	                if(sum == 100)  {
	                    n_i = i;
	                    n_j = j;
	                    break;
	                }else   {
	                    sum = 0;
	                }
	            }
	             
	        }
	 
	        for(int i = 0; i < 9; i++)   {
	            if(i != n_i && i != n_j)    {
	                System.out.println(arr.get(i));
	            }
	        }


		
	}
}

