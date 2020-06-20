package programers;

import java.util.ArrayList;

public class NumBaseball {

	public static void main(String[] args) {
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		int answer=0;
		ArrayList<String> numList = createNum();
		
		for(int i=0;i<numList.size();i++){
			if(check(numList.get(i),baseball)){
				answer++;
				System.out.println(numList.get(i));
			}
		}
		System.out.println(answer);
		
	}
	public static ArrayList<String> createNum(){
		ArrayList<String> list = new ArrayList<>();
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				for(int k=1;k<=9;k++){
					if(i!=j && j!=k && i!=k){
						list.add(String.valueOf(i)+String.valueOf(j)+String.valueOf(k));
					}
				}
			}
		}
		return list;
	}
	public static boolean check(String num,int[][] baseball){
		
		boolean check = true;
		for(int i=0;i<baseball.length;i++){
			int strikeCnt=0;
			int ballCnt=0;
			String baseNum = String.valueOf(baseball[i][0]);
			//인덱스,숫자 같은지
			for(int j=0;j<num.length();j++){
				if(num.charAt(j)==baseNum.charAt(j)) strikeCnt++;
			}
			//숫자만 같고 인덱스는 다른지
			for(int j=0;j<num.length();j++){
				for(int k=0;k<baseNum.length();k++){
					if(num.charAt(j)==baseNum.charAt(k)&& j!=k) ballCnt++;
				}
			}
			if(baseball[i][1]!=strikeCnt || baseball[i][2]!=ballCnt)
				check = false;
		}
		
		return check;
	}
}
