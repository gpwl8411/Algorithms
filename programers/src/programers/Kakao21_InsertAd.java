package programers;

public class Kakao21_InsertAd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//카카오 21 블라인드 광고삽입
		String play_time="02:03:55"; 
		String adv_time="00:14:15"; 
		String[] logs= {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		
		int playT = secTime(play_time);
		int advT = secTime(adv_time);
		long[] play = new long[playT+1];

		for(int i=0;i<logs.length;i++) {
			String[] str = logs[i].split("-");
			int startT = secTime(str[0]);
			int finishT = secTime(str[1]);
			play[startT]++;
			play[finishT]--;

		}
		for(int i=1;i<=playT;i++) {
			play[i]+=play[i-1];
		}
		for(int i=1;i<=playT;i++) {
			play[i]+=play[i-1];
		}
		long max = play[advT];
		int ansT = 0;
		
		int startT = 0, endT = startT + advT;
        while (endT <= playT) {
            long current = play[endT] - play[startT];
            if (current > max) {
                ansT = startT+1;
                max = current;
            }

            startT++;
            endT++;
        }
		System.out.println(stringTime(ansT));
	}
	static String stringTime(int time) {
		String hh = String.format("%02d", time/3600);
		String mm = String.format("%02d", time%3600/60);
		String ss = String.format("%02d", time%60);
		return hh+":"+mm+":"+ss;
	}
	static int secTime(String s) {
		int time = 0;
		String[] str = s.split(":");
		time+=Integer.parseInt(str[0])*3600;
		time+=Integer.parseInt(str[1])*60;
		time+=Integer.parseInt(str[2]);
		return time;
	}

}
