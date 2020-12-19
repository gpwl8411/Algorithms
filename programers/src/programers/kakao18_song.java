package programers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class kakao18_song {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] musicinfos = {"12:00,12:06,HELLO,FFF"};
		String m = "CDEFGAC";
		String[] oldM = {"C#","D#","E#","F#","G#","A#"};
		String[] newM = {"c","d","e","f","g","a"};
		for(int i=0;i<oldM.length;i++) {
			m = m.replace(oldM[i], newM[i]);
		}
		PriorityQueue<Song2> q = new PriorityQueue<>();
		
		for(int i=0;i<musicinfos.length;i++) {
			String[] str = musicinfos[i].split(",");
			String[] time = str[0].split(":");
			
			int startT = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
			time = str[1].split(":");
			int finishT = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
			int playT = finishT-startT;
			
			
			List<String> list = new ArrayList<>();
			for(int j=0;j<str[3].length();j++) {
				char c = str[3].charAt(j);
				if(c=='#') {
					String s = list.remove(list.size()-1);
					list.add(s.toLowerCase());
				}
				else {
					list.add(c+"");
				}
			}

			String music = String.join("", list);
			int idx=0;
			int size = list.size();
			while(size<playT) {
				music+=list.get(idx++%list.size());
				size++;
			}
			if(size!=playT) {
				music = String.join("", list.subList(0, playT));
			}
			if(music.contains(m) || m.contains(music))
				q.add(new Song2(startT,playT,str[2]));
		}
		
		if(q.isEmpty())
			System.out.println("\"(None)\"");
		else
			System.out.println(q.poll().name);
		
	}
}
class Song2 implements Comparable<Song2>{
	int startT;
	int playT;
	String name;
	
	Song2(int startT,int playT,String name){
		this.startT = startT;
		this.playT = playT;
		this.name = name;		
	}

	@Override
	public int compareTo(Song2 s) {
		if(playT == s.playT) {
			return startT - s.startT;
		}
		return s.playT - playT;
	}
	
}
