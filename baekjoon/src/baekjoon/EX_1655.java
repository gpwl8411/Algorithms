package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class EX_1655 {
	static Queue<Integer> minq = new PriorityQueue<>();
	static Queue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		maxq.add(Integer.parseInt(br.readLine()));
		bw.append(maxq.peek()+"\n");
		for(int i=1;i<n;i++){
			if(maxq.size()== minq.size())
				maxq.add(Integer.parseInt(br.readLine()));
			else
				minq.add(Integer.parseInt(br.readLine()));
			int mid = swap();
			bw.append(mid+"\n");
		}
		bw.flush();
		bw.close();
	}
	public static int swap(){
	
		if(maxq.peek() > minq.peek()){
			int tmp = maxq.poll();
			minq.add(tmp);
			maxq.add(minq.poll());
		}
		return maxq.peek();
		
	}
	

}
