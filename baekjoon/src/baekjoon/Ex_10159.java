package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Ex_10159 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] dist = new boolean[n+1][n+1];
        boolean[][] revDist = new boolean[n+1][n+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i==j)
                    dist[i][j] = true;
            }
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = true;
            revDist[b][a] = true;
        }

        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(dist[i][k] && dist[k][j])
                        dist[i][j] = true;
                    if(revDist[i][k] && revDist[k][j])
                        revDist[i][j] = true;
                }
            }
        }

        for(int i=1;i<=n;i++) {
            int cnt = 0;
            for(int j=1;j<=n;j++) {
                if(dist[i][j] || revDist[i][j]) {
                    cnt++;
                }
            }
            bw.append((n-cnt)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
