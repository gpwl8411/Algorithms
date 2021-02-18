package programers;


public class Kakao17_GroupPhoto {

//	static Set<String> set = new HashSet<>();
	static Condition[] cData;
	static int ans=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//2017 카카오코드본선 단체사진 찍기
		int n=2;
		String[] data= {"M~C=2", "C~M>1"};
		cData = new Condition[n];
		ans=1;
		for(int i=2;i<=8;i++) {
			ans *= i;
		}
		
		for(int i=0;i<n;i++) {
			String s1 = data[i].substring(0, 1);
			String s2 = data[i].substring(2,3);
			char op = data[i].charAt(3);
			int num = (data[i].charAt(4)-'0');
			cData[i] = new Condition(s1,s2,op,num);
		}
		String[] arr = {"A","C","F","J","M","N","R","T"};
		permutation(arr,0,arr.length,arr.length);
		System.out.println(ans);
	}
	static boolean check(String s) {
		
		for(int i=0;i<cData.length;i++) {
			Condition c= cData[i];
			int idx = Math.abs(s.indexOf(c.s1)-s.indexOf(c.s2))-1;
			switch (c.op){
				case '=':
					if(idx!=c.num) {
						return false;
					}
					break;
				case '<':
					if(idx>=c.num) {
						return false;
					}
					break;
				case '>':					
					if(idx<=c.num) {
						return false;
					}
					break;
			}
		}
		return true;
	}
	static void permutation(String[] arr, int depth, int n, int r) {
	    if (depth == r) {
	        StringBuilder sb = new StringBuilder();
	        for(int i=0;i<r;i++) {
	        	sb.append(arr[i]);
	        }
	        if(!check(sb.toString())) {
	        	ans--;
	        }
	    	return;
	    }
	 
	    for (int i=depth; i<n; i++) {
	        swap(arr, depth, i);
	        permutation(arr, depth + 1, n, r);
	        swap(arr, depth, i);
	    }
	}
	 
	static void swap(String[] arr, int depth, int i) {
	    String temp = arr[depth];
	    arr[depth] = arr[i];
	    arr[i] = temp;
	}

}
class Condition{
	String s1;
	String s2;
	char op;
	int num;
	
	Condition(String s1,String s2,char op,int num){
		this.s1 = s1;
		this.s2 = s2;
		this.op = op;
		this.num = num;
	}
}

