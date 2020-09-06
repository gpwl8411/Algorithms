package programers;


public class Kakao20_columnBeam {
	static boolean[][] column;
	static boolean[][] beam;
	public static void main(String[] args) {

		int n = 5;
		int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 },{1,1,1,0},{2,2,0,1} };

		column = new boolean[n+3][n+3];
		beam = new boolean[n+3][n+3];
		int cnt=0;
		for (int i = 0; i < build_frame.length; i++) {
//			for(int j=0;j<build_frame[0].length;j++) {
			int y = build_frame[i][0]+1;
			int x = build_frame[i][1]+1;
			
			// column
			if (build_frame[i][2] == 0) {
				//삭제
				if(build_frame[i][3]==0) {
					//삭제가 가능할 경우
					if(check('c',x,y,0)) {
						column[x][y]=false;
						cnt--;
					}
				}
				//설치
				else {
					if(check('c',x,y,1)) {
						column[x][y]=true;
						cnt++;
					}
					
				}
			}
			//beam
			else {
				//삭제
				if(build_frame[i][3]==0) {
					//삭제가 가능할 경우
					if(check('b',x,y,0)) {
						beam[x][y]=false;
						cnt--;
					}
				}
				//설치
				else {
					if(check('b',x,y,1)) {
						beam[x][y]=true;
						cnt++;
					}
				}
				
			}
//			}
		}
		int[][] answer = new int[cnt][3];
		int index=0;
		for(int j=1;j<beam.length;j++) {
			for(int i=1;i<beam.length;i++) {
				if(column[i][j]) {
					answer[index][0]=j-1;
					answer[index][1]=i-1;
					answer[index][2]= 0;
					index++;
				}
				if(beam[i][j]) {
					answer[index][0]=j-1;
					answer[index][1]=i-1;
					answer[index][2]= 1;
					index++;
				}

			}
		}
//		return answer;
		
	}
	static boolean check(char kind,int x, int y ,int work) {
		boolean flag=true;
		//설치
		if(work==1) {
			//기둥
			if(kind == 'c') {
				return x==1 || beam[x][y-1] || beam[x][y] || column[x-1][y];
			}
			//보
			else {
				return column[x-1][y] || column[x-1][y+1] || (beam[x][y-1] && beam[x][y+1]);
			}
		}
		//삭제
		else {
			if(kind == 'c') column[x][y]=false;
			else beam[x][y]=false;
			
			for(int i=1;i<beam.length-1;i++) {
				for(int j=1;j<beam.length-1;j++) {
					if(column[i][j] && !check('c',i,j,1)) {
						flag=false;
					}
					if(beam[i][j] && !check('b',i,j,1)) {
						flag = false;
					}
				}
			}
			if(kind=='c') column[x][y]=true;
			else beam[x][y] = true;
		}
		
		return flag;
	}

}

