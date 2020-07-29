package programers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class BestRecord {

	public static void main(String[] args) {

		String[] genres= {"classic", "pop", "classic", "classic", "pop","zazz","zazz"};
		int[] plays = {500, 600, 150, 800, 2500,4000,100};
		int ansSize=0;
		HashMap<String,PriorityQueue<Song>> map = new HashMap<>();
		for(int i=0;i<plays.length;i++) {
			PriorityQueue<Song> list;
			if(map.containsKey(genres[i])) {
				list = map.get(genres[i]);
				if(map.get(genres[i]).size()==1) ansSize++;
			}else {
				list = new PriorityQueue<>();
				ansSize++;
			}
			list.add(new Song(i,plays[i]));
			map.put(genres[i], list);
		}
		int[] answer = new int[ansSize];
		Comparator<Integer> comparator = (o1, o2)->o2.compareTo(o1);
		Map<Integer, String> sortingMap = new TreeMap<>(comparator);
		for(String key : map.keySet()) {
			int sum = 0;
			int size = map.get(key).size();
			PriorityQueue<Song> val = new PriorityQueue<Song>();
			for(int i=0;i<size;i++) {
				Song song = map.get(key).poll();
				sum += song.play;
				val.add(song);
			}
			map.put(key, val);
			sortingMap.put(sum, key);
		}
		int index=0;
		for(Integer i : sortingMap.keySet()) {
			String key = sortingMap.get(i);
			if(map.get(key).size()==1) {
				answer[index++] = map.get(key).poll().no;				
			}else {
				answer[index++] = map.get(key).poll().no;
				answer[index++] = map.get(key).poll().no;
			}
		}
		for(int i : answer) {
			System.out.println(i);
		}
		
		
		
	}

}
class Song implements Comparable<Song>{
	int no;
	int play;
	Song(int no, int play){
		this.no = no;
		this.play = play;
	}
	public int compareTo(Song s) {
        if(this.play > s.play) {
            return -1; // 내림차순
        }
        else if(this.play== s.play) {
            if(this.no < s.no) {
                return -1;
            }
        }
        return 1; // 이미 this.first가 더 큰 것이 됐으므로, 1로 해준다. -1로
        // -1로 하면 결과가 이상하게 출력됨.
    }
	
}
