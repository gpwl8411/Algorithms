package baekjoon;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class ex_2668_2 {
	static int[] arr;
    static boolean[] visited;
    static int last;
    static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 
        int N = sc.nextInt();
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<Integer>();
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            visited[i] = true;    //���� ��Ϳ� ������ �ȵǹǷ� ù �������� �湮���� üũ
            last = i;
            DFS(i);
            visited[i] = false; //���� ���� DFS�� �ؾ��ϹǷ� �ʱ�ȭ �����ش�.
        }
        Collections.sort(list);    // ������ ���� ����ؾ��ϹǷ� ������
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);    //list���� �ϳ��� ������ش�.
        }
       


}
	 public static void DFS(int i) {
         
         if (!visited[arr[i]]) {     //������ �湮�� ���� �ƴϿ����Ѵ�.
             visited[arr[i]] = true;     // �湮�����Ƿ� true
             DFS(arr[i]);
             visited[arr[i]] = false; // ���� DFS���� ���Ͽ� false
         }
         if (arr[i] == last) {    //������ ���� ������� ���ٸ� ����Ŭ�� �ϼ������Ƿ� ����Ʈ�� �߰�
             list.add(last);
         }
	}
}
