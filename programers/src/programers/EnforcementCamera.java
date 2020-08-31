package programers;


import java.util.Arrays;


public class EnforcementCamera {

	public static void main(String[] args) {
		int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
		int answer=1;
		Arrays.sort(routes, (a, b) -> Integer.compare(a[0], b[0]));
		
		int start = routes[0][0];
		int finish = routes[0][1];
		for(int i=1;i<routes.length;i++) {
			if(routes[i][0]>finish || routes[i][1]<start) {
				answer++;
				start = routes[i][0];
				finish = routes[i][1];
				
//				System.out.println("i="+i);
			}else {
				start = Math.max(start,routes[i][0]);
				finish = Math.min(finish, routes[i][1]);
			}
		}
		System.out.println(answer);
	}

}
