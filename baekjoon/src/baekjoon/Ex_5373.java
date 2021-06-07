package baekjoon;

import java.io.*;
import java.util.*;

public class Ex_5373 {
	   static final int U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;
	    static InputReader in;
	    static PrintWriter out;
	    
	    int T, n;
	    char[][][] cube;
	    
	    
	    
	    public static void main(String[] args) {
	        in = new InputReader(System.in);
	        out = new PrintWriter(System.out);
	        new Ex_5373().solve();
	        out.close();
	    }
	    void init(char[] colors) {
	        int num = colors.length;
	        cube = new char[num][][];
	        
	        for (int i=0; i<num; ++i) {
	            cube[i] = new char[3][3];
	            for (int j=0; j<3; ++j)
	                for (int k=0; k<3; ++k)
	                    cube[i][j][k] = colors[i];
	        }
	    }
	    
	    void alter(int f, int u, int l, int d, int r, boolean clk) {
	        char[][] tmp = new char[3][3];
	        char[] tmp2 = new char[3];
	        
	        if (clk) {
	            for (int i=0; i<3; ++i)
	                for (int j=0; j<3; ++j) {
	                    tmp[i][j] = cube[f][2-j][i];
	                }
	            for (int i=0; i<3; ++i)
	                tmp2[i] = cube[u][i][0];
	            for (int i=0; i<3; ++i)
	                cube[u][i][0] = cube[l][0][2-i];
	            for (int i=0; i<3; ++i)
	                cube[l][0][2-i] = cube[d][2][i];
	            for (int i=0; i<3; ++i)
	                cube[d][2][i] = cube[r][2-i][2];
	            for (int i=0; i<3; ++i)
	                cube[r][2-i][2] = tmp2[i];
	        }
	        else {
	            for (int i=0; i<3; ++i)
	                for (int j=0; j<3; ++j) {
	                    tmp[i][j] = cube[f][j][2-i];
	                }
	            for (int i=0; i<3; ++i)
	                tmp2[i] = cube[u][i][0];
	            for (int i=0; i<3; ++i)
	                cube[u][i][0] = cube[r][2-i][2];
	            for (int i=0; i<3; ++i)
	                cube[r][2-i][2] = cube[d][2][i];
	            for (int i=0; i<3; ++i)
	                cube[d][2][i] = cube[l][0][2-i];
	            for (int i=0; i<3; ++i)
	                cube[l][0][2-i] = tmp2[i];
	        }
	        cube[f] = tmp;
	    }
	    
	    void rotate(String str) {
	        boolean clk = str.charAt(1) == '+';
	        
	        switch (str.charAt(0)) {
	        case 'U': alter(U, L, F, R, B, clk); break;
	        case 'D': alter(D, B, R, F, L, clk); break;
	        case 'F': alter(F, U, L, D, R, clk); break;
	        case 'B': alter(B, R, D, L, U, clk); break;
	        case 'L': alter(L, F, U, B, D, clk); break;
	        case 'R': alter(R, D, B, U, F, clk); break;
	        }
	    }
	    
	    void printU() {
	        for (int i=0; i<3; ++i) {
	            for (int j=0; j<3; ++j)
	                out.print(cube[0][j][2-i]);
	            out.println();
	        }
	    }
	    
	    void solve() {
	        T = in.nextInt();
	        while (T-->0) {
	            init(new char[]{'w','y','r','o','g','b'});
	            n = in.nextInt();
	            while (n-->0) {
	                rotate(in.nextStr());
	            }
	            printU();
	        }
	    }
	    
	    static class InputReader {
	        BufferedReader br;
	        StringTokenizer st;
	        
	        public InputReader(InputStream is) {
	            br = new BufferedReader(new InputStreamReader(is));
	            st = null;
	        }
	        
	        public String nextStr() {
	            while (st == null || !st.hasMoreTokens()) {
	                try {
	                    st = new StringTokenizer(br.readLine());
	                }
	                catch (IOException e) {
	                    throw new RuntimeException(e);
	                }
	            }
	            return st.nextToken();
	        }
	        
	        public int nextInt() {
	            return Integer.parseInt(nextStr());
	        }
	    }
//	static char[][][] cube = new char[6][3][3];
//	static char[] color = { 'o', 'w', 'r', 'y', 'g', 'b' };
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		// 삼성 sw역량테스트 - 큐빙
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st;
//		int t = Integer.parseInt(br.readLine());
//
//		while (t-- > 0) {
//			int n = Integer.parseInt(br.readLine());
//			st = new StringTokenizer(br.readLine());
//			initCube();
//			while (n-- > 0) {
//				String s = st.nextToken();
//				char side = s.charAt(0);
//				char dir = s.charAt(1);
//				move(side, dir);
//
//			}
//			for (int ii = 0; ii < 6; ii++) {
//				for (int i = 0; i < 3; i++) {
//					for (int j = 0; j < 3; j++) {
//						bw.append(cube[ii][i][j]);
//					}
//					bw.append("\n");
//				}
//				bw.append("====\n");
//			}
//		}
//		bw.flush();
//
//	}
//
//	// U: 윗 면, D: 아랫 면, F: 앞 면, B: 뒷 면, L: 왼쪽 면, R: 오
//	static void move(char side, char dir) {
//		int[] sides = null;
//		int[] rows = null;
//		int[] cols = null;
//		int selectSide = -1;
//		switch (side) {
//		case 'U':
//			selectSide = 1;
//			sides = new int[] { 0, 5, 2, 4 };
//			rows = new int[] { 0, 0, 0, 0 };
//			cols = new int[] { -1, -1, -1, -1 };
//			break;
//		case 'D':
//			selectSide = 3;
//			sides = new int[] { 0, 4, 2, 5 };
//			rows = new int[] { 2, 2, 2, 2 };
//			cols = new int[] { -1, -1, -1, -1 };
//			break;
//		case 'F':
//			selectSide = 2;
//			sides = new int[] { 1, 5, 3, 4 };
//			rows = new int[] { 2, -1, 0, -1 };
//			cols = new int[] { -1, 0, -1, 2 };
//			break;
//		case 'B':
//			selectSide = 0;
//			sides = new int[] { 1, 4, 3, 5 };
//			rows = new int[] { 0, -1, 2, -1 };
//			cols = new int[] { -1, 0, -1, 2 };
//			break;
//		case 'L':
//			selectSide = 4;
//			sides = new int[] { 1, 2, 3, 0 };
//			rows = new int[] { -1, -1, -1, -1 };
//			cols = new int[] { 0, 0, 0, 2 };
//			break;
//		case 'R':
//			selectSide = 5;
//			sides = new int[] { 1, 0, 3, 2 };
//			rows = new int[] { -1, -1, -1, -1 };
//			cols = new int[] { 2, 0, 2, 2 };
//			break;
//		}
//		if (dir == '+')
//			clockwise(selectSide, sides, rows, cols);
//		else
//			counterclockwise(selectSide, sides, rows, cols);
//
//	}
//
//	static void clockwise(int selectSide, int[] sides, int[] rows, int[] cols) {
//		char[][][] tmp = copy();
//		cube[selectSide][0][0] = tmp[selectSide][1][0];
//		cube[selectSide][0][1] = tmp[selectSide][0][0];
//		cube[selectSide][0][2] = tmp[selectSide][0][1];
//		cube[selectSide][1][0] = tmp[selectSide][2][0];
//		cube[selectSide][1][2] = tmp[selectSide][0][2];
//		cube[selectSide][2][0] = tmp[selectSide][2][1];
//		cube[selectSide][2][1] = tmp[selectSide][2][2];
//		cube[selectSide][2][2] = tmp[selectSide][1][2];
//
//		for (int i = 0; i < 4; i++) {
//			int j = i - 1 == -1 ? 3 : i - 1;
//			if (rows[i] == -1) {
//				if (rows[j] == -1) {
//					for (int k = 0; k < 3; k++) {
//						cube[sides[i]][k][cols[i]] = tmp[sides[j]][k][cols[j]];
//					}
//				} else {
//					for (int k = 0; k < 3; k++) {
//						cube[sides[i]][k][cols[i]] = tmp[sides[j]][rows[j]][k];
//					}
//				}
//			} else {
//				if (rows[j] == -1) {
//					for (int k = 0; k < 3; k++) {
//						cube[sides[i]][rows[i]][k] = tmp[sides[j]][k][cols[j]];
//					}
//				} else {
//					for (int k = 0; k < 3; k++) {
//						cube[sides[i]][rows[i]][k] = tmp[sides[j]][rows[j]][k];
//					}
//				}
//			}
//		}
//	}
//
//	static void counterclockwise(int selectSide, int[] sides, int[] rows, int[] cols) {
//		char[][][] tmp = copy();
//		cube[selectSide][0][0] = tmp[selectSide][0][1];
//		cube[selectSide][0][1] = tmp[selectSide][0][2];
//		cube[selectSide][0][2] = tmp[selectSide][1][2];
//		cube[selectSide][1][0] = tmp[selectSide][0][0];
//		cube[selectSide][1][2] = tmp[selectSide][2][2];
//		cube[selectSide][2][0] = tmp[selectSide][1][0];
//		cube[selectSide][2][1] = tmp[selectSide][2][0];
//		cube[selectSide][2][2] = tmp[selectSide][2][1];
//
//		for (int i = 0; i < 4; i++) {
//			int j = i + 1 == 4 ? 0 : i + 1;
//			if (rows[i] == -1) {
//				if (rows[j] == -1) {
//					for (int k = 0; k < 3; k++) {
//						cube[sides[i]][k][cols[i]] = tmp[sides[j]][k][cols[j]];
//					}
//				} else {
//					for (int k = 0; k < 3; k++) {
//						cube[sides[i]][k][cols[i]] = tmp[sides[j]][rows[j]][k];
//					}
//				}
//			} else {
//				if (rows[j] == -1) {
//					for (int k = 0; k < 3; k++) {
//						cube[sides[i]][rows[i]][k] = tmp[sides[j]][k][cols[j]];
//					}
//				} else {
//					for (int k = 0; k < 3; k++) {
//						cube[sides[i]][rows[i]][k] = tmp[sides[j]][rows[j]][k];
//					}
//				}
//			}
//		}
//	}
//
//	static char[][][] copy() {
//		char[][][] tmp = new char[6][3][3];
//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < 3; j++) {
//				for (int k = 0; k < 3; k++) {
//					tmp[i][j][k] = cube[i][j][k];
//				}
//			}
//		}
//		return tmp;
//	}
//
//	static void initCube() {
//
//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < 3; j++) {
//				for (int k = 0; k < 3; k++) {
//					cube[i][j][k] = color[i];
//				}
//			}
//		}
//	}

}
