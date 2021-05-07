package programers;

public class KakaoIntern20_PressDownKey {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//카카오20 인턴쉽 키패드 누르기
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		Pair left = new Pair(3,0);
		Pair right = new Pair(3,2);
		
		for(int i=0;i<numbers.length;i++) {
			int num = numbers[i]-1;
			if(numbers[i]==0)
				num=10;
			int x = num/3;
			int y = num%3;
			if(y==0) {
				move(left,x,y,"L");
			}
			else if(y==2) {
				move(right,x,y,"R");
			}else {
				int dL = dist(left,new Pair(x,y));
				int dR = dist(right,new Pair(x,y));
				if(dL < dR) {
					move(left,x,y,"L");
				}else if(dL > dR) {
					move(right,x,y,"R");
				}else {
					if(hand.equals("left")) {
						move(left,x,y,"L");
					}else {
						move(right,x,y,"R");
					}
				}
			}
		}
		System.out.println(sb);
		
	}
	static void move(Pair p, int x, int y, String hand) {
		p.x = x;
		p.y = y;
		sb.append(hand);
	}
	static int dist(Pair p1, Pair p2) {
		int xd = Math.abs(p1.x-p2.x);
		int yd = Math.abs(p1.y-p2.y);
		return xd+yd;
	}

	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

