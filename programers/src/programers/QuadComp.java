package programers;

public class QuadComp {

	static int[] answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//쿼드압축 후 개수 세기
		int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		answer = new int[2];
		divide(0,0,arr.length,arr);
		System.out.println(answer[0]+","+answer[1]);
	}
	static void divide(int row,int col,int n,int[][] arr) {
	
		if(check(row,col,n,arr)==0)
			answer[0]+=1;
		else if(check(row,col,n,arr)==1)
			answer[1]+=1;
		else {
			int mid = n/2;
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					divide(row+mid*i,col+mid*j,mid,arr);
				}
			}
		}
		
	}
	static int check(int row,int col,int n,int[][] arr) {
		int val = arr[row][col];
		for(int i=row;i<row+n;i++) {
			for(int j=col;j<col+n;j++) {
				if(arr[i][j]!=val)
					return -1;
			}
		}
		if(val==1)return 1;
		else return 0;
	}

}
