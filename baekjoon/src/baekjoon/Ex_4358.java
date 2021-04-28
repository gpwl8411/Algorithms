package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ex_4358 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//생태학
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<String,Double> map = new HashMap<>();
		double cnt = 0;
		
		String str = br.readLine();
		while(true) {
			if( str == null || str.equals("") || str.length()==0)
				break;
			map.put(str, map.getOrDefault(str, 0.0)+1);
			cnt++;
			str = br.readLine();
		}
		
		Object[] keys = map.keySet().toArray();
		Arrays.sort(keys);
		
		for(Object key : keys) {
			String curKey = (String)key;
			double num = map.get(curKey)*100.0;
			bw.append(curKey+" "+String.format("%.4f", num/cnt)+"\n");
		}
		bw.flush();
		bw.close();
	}

}
