package programers;

import java.math.BigDecimal;
import java.text.ParseException;

public class Kakao18_Traffic {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		//카카오18 블라인드 추석 트래픽
		String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
		Times[] times = new Times[lines.length];
		
		for(int i=0;i<lines.length;i++) {
			String[] str= lines[i].split(" ");
			String[] time = str[1].split(":");
			int h = Integer.parseInt(time[0]);
			int m = Integer.parseInt(time[1]);
			double s = Double.parseDouble(time[2]);
			BigDecimal workT = new BigDecimal(str[2].substring(0,str[2].length()-1));
			//System.out.println(workT-0.001);
//			workT = workT-0.001;
			BigDecimal bigDecimal = new BigDecimal("0.001");
			workT = workT.subtract(bigDecimal);
			
			BigDecimal finishT = new BigDecimal(h*3600+m*60+s);
			BigDecimal startT = finishT.subtract(workT);
			startT = startT.setScale(3,BigDecimal.ROUND_HALF_UP);
			finishT = finishT.setScale(3,BigDecimal.ROUND_HALF_UP);
			times[i] = new Times(startT,finishT);
			
			
		}
		int max = 0;
		for(int i=0;i<times.length;i++) {
			BigDecimal startT = times[i].start;
			BigDecimal finishT = times[i].finish;
			BigDecimal addT = new BigDecimal("0.999");
			
			int cnt=0;
			for(int j=0;j<times.length;j++) {
				if(times[j].start.equals(startT) ||times[j].start.equals(startT.add(addT))
						|| times[j].finish.equals(startT) || times[j].finish.equals(startT.add(addT)) ) {
					cnt++;
				}
				else if(times[j].start.compareTo(startT)==-1 && times[j].finish.compareTo(startT.add(addT))==1) {
					cnt++;
				}else if(times[j].start.compareTo(startT) ==1  && times[j].start.compareTo(startT.add(addT))==-1) {
					cnt++;
				}else if(times[j].finish.compareTo(startT) ==1 && times[j].finish.compareTo(startT.add(addT))==-1) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
			cnt=0;
			for(int j=0;j<times.length;j++) {
				if(times[j].start.equals(finishT) ||times[j].start.equals(finishT.add(addT))
						|| times[j].finish.equals(finishT) || times[j].finish.equals(finishT.add(addT)) ) {
					cnt++;
				}
				else if(times[j].start.compareTo(finishT)==-1 && times[j].finish.compareTo(finishT.add(addT))==1) {
					cnt++;
				}else if(times[j].start.compareTo(finishT) ==1  && times[j].start.compareTo(finishT.add(addT))==-1) {
					cnt++;
				}else if(times[j].finish.compareTo(finishT) ==1 && times[j].finish.compareTo(finishT.add(addT))==-1) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
		
	}

}
class Times{
	BigDecimal start;
	BigDecimal finish;
	Times(BigDecimal start,BigDecimal finish){
		this.start = start;
		this.finish = finish;
	}
	
}
