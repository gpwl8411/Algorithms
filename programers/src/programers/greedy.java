package programers;
import java.util.*;
public class greedy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner input = new Scanner(System.in);
				String number = input.next();
				int k = input.nextInt();
		        String answer = "";

		        List<Integer> list = new ArrayList<Integer>();
		        for (char c : number.toCharArray()) {
		          list.add(Character.getNumericValue(c));
		        }
		        int i=0;
		        while(i<k){
		            int min = list.get(0);
		            int index = 0;
		            for(int j=0;j<number.length()-k;j++){
		            	System.out.println(min+":"+index);
		            	System.out.println(list.get(j));
		            	if(min>list.get(j)){
		                    min =list.get(j);
		                    index = j;
		                    
		                }
       
		            }
		            list.remove(index);
		            i++;
		        }
		        for(int j=0;j<list.size();j++){
		                answer += list.get(j);
		        }
		     
		    
		        System.out.println( answer);

	
}
	}

