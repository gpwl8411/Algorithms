package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Ex_15686 {
	
	static int minDistance = Integer.MAX_VALUE;
	static ArrayList<Point> house;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Point> chicken = new ArrayList<Point>() ;
		house = new ArrayList<Point>() ;
		String[] str = in.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[][] g = new int[n][n];
		for (int i = 0; i < n; i++) {
			str = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				g[i][j] = Integer.parseInt(str[j]);
				if(g[i][j]==1) house.add(new Point(i,j));
				if(g[i][j]==2) chicken.add(new Point(i,j));
			}
		}
		boolean[] visited = new boolean[chicken.size()];
		chickenSet(chicken, visited, 0, chicken.size(), m);
		System.out.println(minDistance);

	}
	 static void chickenSet(ArrayList<Point> arr, boolean[] visited, int start, int n, int r) {
	        if (r == 0) {
	            int min = getDistance(arr, visited, n);
	            if(min<minDistance)
	            	minDistance = min;
	            return;
	        }

	        for (int i = start; i < n; i++) {
	            visited[i] = true;
	            chickenSet(arr, visited, i + 1, n, r - 1);
	            visited[i] = false;
	        }
	    }

	 public static int getDistance(ArrayList<Point> arr,boolean[] visited,int n){
		int distance=0;
		 for(int i=0;i<house.size();i++){
			 int min=Integer.MAX_VALUE;
			 for (int j = 0; j < n; j++) {
				 int dis = Math.abs(arr.get(j).x-house.get(i).x)+Math.abs(arr.get(j).y-house.get(i).y);
				 if (visited[j] == true)
					 if(dis<min){
						min = dis; 
					 }
			 }
			 distance+=min;
		 }
		 return distance;
	 }

}
class Point{
	int x;
	int y;
	Point(int x,int y){
		this.x =x;
		this.y =y;
	}

}
