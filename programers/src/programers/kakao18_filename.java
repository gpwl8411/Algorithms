package programers;

import java.util.Arrays;
import java.util.Comparator;

public class kakao18_filename {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] files = {"F-15 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14","F-14 Comcat"};
		String[] answer={};

		Arrays.sort(files, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String head1="";
				String number1="";
				for(int i=0;i<o1.length();i++){
					if(o1.charAt(i)>='0'&& o1.charAt(i)<='9'){
						for(int j=i;j<o1.length();j++){
							
							if(o1.charAt(j)>='0'&& o1.charAt(j)<='9'){
								number1+=o1.charAt(j);
							}else{
								break;
							}
						}
						break;
					}
					head1+=o1.charAt(i);
				}
				head1=head1.toLowerCase();
				
				String head2="";
				String number2="";
				for(int i=0;i<o2.length();i++){
					if(o2.charAt(i)>='0'&& o2.charAt(i)<='9'){
					for(int j=i;j<o2.length();j++){
						if(o2.charAt(j)>='0'&& o2.charAt(j)<='9'){
							number2+=o2.charAt(j);
						}else{
							break;
						}
					}
					break;
					}
					head2+=o2.charAt(i);
				}
				head2=head2.toLowerCase();
				
				if(head1.equals(head2)){
					Integer n1=Integer.parseInt(number1);
					Integer n2=Integer.parseInt(number2);
					return Integer.compare(n1, n2);
				}
				return head1.compareTo(head2);
			}
			
		});
		for(int i=0;i<files.length;i++){
			System.out.println(files[i]);
		}
	}

}
