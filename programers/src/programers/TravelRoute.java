package programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TravelRoute {
	
	static ArrayList<String[]> list = new ArrayList<>();
	public static void main(String[] args) {

		String[][] tickets ={ {"ICN", "SFO"}, {"ICN", "ATL"},{"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		
		String start = "ICN";
		String[] answer = new String[tickets.length+1];
 		boolean[] visited = new boolean[tickets.length+1];
		dfs(visited,start,tickets,0,answer);

		if(list.size()>1){
			Collections.sort(list,new Comparator<String[]>(){

				@Override
				public int compare(String[] o1, String[] o2) {
					int compare;
					String s1="";
					String s2="";
					for(int i=0;i<o1.length;i++){
						s1+=o1[i];
						s2+=o2[i];
					}
					return s1.compareTo(s2);
				}
				
			});
		}
		answer = list.get(0);
		for(String s : answer){
			System.out.print(s+" ");
		}
		System.out.println();
		answer = list.get(1);
		for(String s : answer){
			System.out.print(s+" ");
		}
		System.out.println();
		answer = list.get(2);
		for(String s : answer){
			System.out.print(s+" ");
		}

	}
	public static void dfs(boolean[] visited, String start,String[][] tickets,int index,String[] answer){
		
		if(index == tickets.length){
			String[] copy = new String[index+1];
			for(int i=0;i<answer.length;i++){
				copy[i] = answer[i];
			}
			list.add(copy);
			return;
		}
		
		for(int i=0;i<tickets.length;i++){
			if(start.equals(tickets[i][0])&&!visited[i]){
				visited[i]=true;
				answer[index]=start;
				answer[index+1] = tickets[i][1];
				dfs(visited,tickets[i][1],tickets,index+1,answer);
				visited[i]=false;
			}
		}
		return;
		
	}


}

