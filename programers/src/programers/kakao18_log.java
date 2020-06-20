package programers;

public class kakao18_log {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String[] lines={"2016-09-15 20:59:57.421 0.351s",
		// "2016-09-15 20:59:58.233 1.181s",
		// "2016-09-15 20:59:58.299 0.8s",
		// "2016-09-15 20:59:58.688 1.041s",
		// "2016-09-15 20:59:59.591 1.412s",
		// "2016-09-15 21:00:00.464 1.466s",
		// "2016-09-15 21:00:00.741 1.581s",
		// "2016-09-15 21:00:00.748 2.31s",
		// "2016-09-15 21:00:00.966 0.381s",
		// "2016-09-15 21:00:02.066 2.62s"
		// };
		String[] lines = { "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s" };
		Time[] t = new Time[lines.length];
		for (int i = 0; i < lines.length; i++) {
			String[] d = lines[i].split(" ");
			String[] str = d[1].split(":");
			// 0=h 1=m 2=s
			float[] finishT = new float[3];
			float[] startT = new float[3];
			float work = Float.parseFloat(d[2].replaceAll("s", ""));

			for (int j = 0; j < str.length; j++) {
				finishT[j] = Float.parseFloat(str[j]);
			}
			float f = 3600 * finishT[0] + 60 * finishT[1] + finishT[2];
			float s = (float) (f - work + 0.001);
			// if(finishT[2]-work < 0){
			//초를 시,분,초로 바꾸는 식.
			// startT[0]=s/3600;
			// startT[1]=s/60%60;
			// startT[2]=s%60;
			// //System.out.println(startT[1]);
			// }else{
			// startT[0]=finishT[0];
			// startT[1]=finishT[1];
			// startT[2]=(float) (finishT[2]-work+0.001);
			// }

			// String finishT[] = {fh,d[1].substring(3,4),
			// d[1].substring(6,7),d[1].substring(9, 11)};
			//

			t[i] = new Time(s, f);

		}
		int max = 0;
		for (int i = 0; i < t.length; i++) {
			int cntS = 0;
			int cntF = 0;
			for (int j = 0; j < t.length; j++) {
				if (i != j) {
//					if (t[i].start <= t[j].start && t[j].start <= t[i].start + 1) {
//						cnt++;
//					} else if (t[i].start <= t[j].finish && t[j].finish <= t[i].start + 1) {
//						cnt++;
//					} else if (t[j].start <= t[i].start && t[i].start <= t[j].start + 1) {
//						cnt++;
//					} else if (t[j].start <= t[i].finish && t[j].finish >= t[i].finish + 1) {
//						cnt++;
//					}
					if(t[i].start<=t[j].finish&&t[i].start+1>=t[j].start||t[i].start-1<=t[j].finish&&t[i].start>=t[j].start){
						cntS++;
					}
					if(t[i].finish<=t[j].finish&&t[i].finish+1>=t[j].start||t[i].finish-1<=t[j].finish&&t[i].finish>=t[j].start){
						cntF++;
					}
				}
			}
			max = Math.max(cntS, max);
			max = Math.max(cntF, max);
		}
		System.out.println(max + 1);
	}

}

class Time {
	float start;
	float finish;

	Time(float s, float f) {
		this.start = s;
		this.finish = f;

	}
}
