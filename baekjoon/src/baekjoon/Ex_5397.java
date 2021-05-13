package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex_5397 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//자료구조 키로거
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		while(n-- > 0) {
			String[] str = br.readLine().split("");
			Deque<String> before = new ArrayDeque<>();
			Deque<String> after = new ArrayDeque<>();
			
			for(int i=0;i<str.length;i++) {
				if(str[i].equals("<")) {
					if(!before.isEmpty()) {
						after.addFirst(before.pollLast());
					}
				}
				else if(str[i].equals(">")) {
					if(!after.isEmpty()) {
						before.addLast(after.pollFirst());
					}
				}else if(str[i].equals("-")) {
					if(!before.isEmpty()) {
						before.pollLast();
					}
				}else {
					before.addLast(str[i]);
				}
			}
			while(!before.isEmpty()) {
				bw.append(before.pollFirst());
			}
			while(!after.isEmpty()) {
				bw.append(after.pollFirst());
			}
			bw.append("\n");
		}
		
		bw.flush();
	}

}
/*
  public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static class Dnode<Character>{
        private char item;
        private Dnode prev;
        private Dnode next;
        public Dnode(char moonja,Dnode p,Dnode n){
            this.item=moonja;
            this.prev=p;
            this.next=n;
        }
    }
    
    static class Dlist{
        protected Dnode head,tail,cursor;
        protected int size;
        public Dlist(){
            this.head=new Dnode(' ',null,null);
            this.tail=new Dnode(' ',this.head,null);
            this.head.next=this.tail;
            this.size=0;
            this.cursor=this.tail;
        }
        
        public void movecursortoleft(){
            if(this.cursor.prev!=this.head)
                this.cursor=this.cursor.prev;
        }
        
        public void movecursortoright(){
            if(this.cursor!=this.tail)
                this.cursor=this.cursor.next;
        }
        
        public void type(char letter){
            Dnode rear=this.cursor.prev;
            Dnode mid=new Dnode(letter,rear,this.cursor);
            this.cursor.prev=mid;
            rear.next=mid;
            this.size++;
        }
        
        public void delete(){
            Dnode target=this.cursor.prev;//node to delete
            if(target!=this.head){
                Dnode rear=target.prev;
                this.cursor.prev=rear;
                rear.next=this.cursor;
                this.size--;
            }
        }
        
        public void print_all() throws IOException{
            Dnode start=this.head.next;
            while(start!=this.tail){
                bw.write(start.item);
                start=start.next;
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException{
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      int t=Integer.parseInt(br.readLine()),len;
      String str;
      Dlist pw;
      while(t>0){
          str=br.readLine();
          len=str.length();
          pw= new Dlist();
          for(int i=0;i<len;i++){
              char elem=str.charAt(i);
              if(elem=='<')
                pw.movecursortoleft();
              else if(elem=='>')
                pw.movecursortoright();
              else if(elem=='-')
                pw.delete();
              else
                pw.type(elem);
          }
          pw.print_all();
          bw.write('\n');
          t--;
      }
      bw.flush();
      bw.close();
    }
}
 */