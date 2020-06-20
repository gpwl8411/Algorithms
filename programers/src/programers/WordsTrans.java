package programers;

public class WordsTrans {

	static int minCnt = Integer.MAX_VALUE;
	public static void main(String[] args) {
		
		String begin = "hit"; 
		String target ="cog"; 
		String[] words ={"hot", "dot", "dog", "lot", "log"};
		
		dfs(new boolean[words.length],0,begin,target,words);
		if(minCnt==Integer.MAX_VALUE)
			minCnt=0;
		System.out.println(minCnt);
		
		
	}
	public static void dfs(boolean[] visited,int cnt,String begin,String target,String[] words){
		
		
		if(begin.equals(target)){
			if(minCnt>cnt)
				minCnt=cnt;
			return;
		}
		
		for(int i=0;i<words.length;i++){
			if(!visited[i] && checkWords(begin,words[i])){
				visited[i]=true;
				dfs(visited,cnt+1,words[i],target,words);
				visited[i]=false;
			}
		}	
		
	}
	//한글자만 바꾸는지 체크
	public static boolean checkWords(String begin,String target){
		
		char[] c1 = begin.toCharArray();
		char[] c2 = target.toCharArray();
		
		int change=0;
		for(int i=0;i<c1.length;i++){
			if(c1[i]!=c2[i]) change++;
		}
		if(change==1) return true;
		
		return false;
	}

}
