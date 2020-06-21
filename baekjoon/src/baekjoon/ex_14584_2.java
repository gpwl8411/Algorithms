package baekjoon;
import java.util.Scanner;
public class ex_14584_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner input = new Scanner(System.in);
	      
	      String data = input.nextLine();
	      
	      int num = input.nextInt();
	      String[] dic = new String[num];
	      String dataResult = "";
	      
	      for(int i = 0; i < dic.length; i++){
	         dic[i] = input.next();
	      }
	      
	      cal :
	      for(int i = 0; i < 26; i++){
	         dataResult = "";
	         
	         for(int j = 0; j < data.length(); j++){
	            int temp = (int)data.charAt(j) + i;
	            if(temp > 122){
	               temp -= 26;
	            }
	            dataResult += (char)temp + "";
	         }
	         
	         for(int j = 0; j < dic.length; j++){
	            if(dataResult.contains(dic[j])){
	               System.out.println(dataResult);
	               break cal;
	            }
	         }
	      }

	   }

	}