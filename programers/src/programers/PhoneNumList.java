package programers;

import java.util.Arrays;

public class PhoneNumList {

	public static void main(String[] args) {
		boolean answer = true;
		String[] phone_book = {"12", "123", "1235", "567", "88"};
		Arrays.sort(phone_book);
		for(int i=1;i<phone_book.length;i++){
			if(phone_book[i-1].length()<phone_book[i].length()){
				if(phone_book[i].contains(phone_book[i-1]))
					answer= false; // ���α׷��ӽ������� ��⼭ �������ָ��
			}
		}
		System.out.println(answer);
	}

}
