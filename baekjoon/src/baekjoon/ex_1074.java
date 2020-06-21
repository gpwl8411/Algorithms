package baekjoon;
import java.util.Scanner;

public class ex_1074 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int r = input.nextInt();
		int c = input.nextInt();
		int size = (int)Math.pow(2,2*(n-1));
		int cnt = 0;
		int qua = 0;
		int[][] z = {{0,1},{2,3}};
		
		if(r<(int)Math.pow(2, n-1)&&c<(int)Math.pow(2, n-1)){
			qua =1;
		}else if(r<(int)Math.pow(2, n-1)&&c>(int)Math.pow(2, n-1)){
			qua=2;
		}else if(r>(int)Math.pow(2, n-1)&&c<(int)Math.pow(2, n-1)){
			qua=3;
		}else{qua=4;}
		
		
		while(true){
			
			r%=(int)Math.pow(2, n-1);
			c%=(int)Math.pow(2, n-1);
			n-=1;
			cnt++;
			if(size<=4) break;
			size=(int)Math.sqrt(size);			
		}
		for(int i=0;i<cnt;i++){
			if(qua==1){
				
			}else if(qua==2){
				z[r][c]+=size;
			}else if(qua==3){
				z[r][c]+=(size*2);
			}else if(qua==4){
				z[r][c]+=(size*3);
			}
			size=(int)Math.pow(size, 2);
		}
		System.out.println(z[r][c]);
		
		
	}

}
