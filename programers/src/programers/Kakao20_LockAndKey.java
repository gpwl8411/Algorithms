package programers;

import java.util.ArrayList;

import java.util.List;

public class Kakao20_LockAndKey {

	static boolean flag = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = { {0,0,0},{1,0,0},{0,1,1} };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int[][] rotateKey;
		int[][] padMap = new int[lock.length + 2 * key.length - 2][lock.length + 2 * key.length - 2];

		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock[0].length; j++) {
				padMap[i + key.length - 1][j + key.length - 1] = lock[i][j];
			}
		}
		print(padMap);
		
		for (int i = 0; i < 4; i++) {
			rotateKey = new int[key.length][key.length];
			if (i != 0) {
				for (int j = 0; j < key.length; j++) {
					for (int k = 0; k < key.length; k++) {
						rotateKey[k][key.length-1-j] = key[j][k];
				
					}
				}
			}else {
				rotateKey = new int[key.length][key.length];
				for (int j = 0; j < key.length; j++) {
					System.arraycopy(key[j], 0, rotateKey[j], 0, key.length);
				};
			}
			for (int j = 0; j < key.length; j++) {
				System.arraycopy(rotateKey[j], 0, key[j], 0, key.length);
			}
			
			int[][] padKey = padding(rotateKey, lock.length);
			if (unlock(padMap, padKey,lock.length,key.length)) {
				System.out.println("true");
			}
			// 수평이동
			for (int j = 1; j < padMap.length; j++) {
				int[][] moveKey = move(padKey, j);
				if(i==1&&j==3) {
				System.out.println("key움직이고나서-수평");
				print(moveKey);
				}
				
				if (unlock(padMap, moveKey,lock.length,key.length)) {
					System.out.println("true");
				}
				// 수직이동
				for (int k = 0; k < padMap.length; k++) {
					moveKey = move(moveKey, 0);
					if(i==1&&j==3&&k==2) {
					System.out.println("key움직이고나서-수직");
					print(moveKey);
					}
					if (unlock(padMap, moveKey,lock.length,key.length)) {
						System.out.println("true");
					}
				}
			}

		}
		System.out.println("ㅎㅎ안되나");

	}

	static int[][] move(int[][] key, int vOrH) {
		int[][] moveKey = new int[key.length][key.length];
		// 수평
		if (vOrH != 0) {
			for (int i = 0; i < key.length; i++) {
				for (int j = 0; j < key.length; j++) {
					if (j + vOrH < key.length && key[i][j] == 1) {
						moveKey[i][j + vOrH] = 1;
					}
				}
			}
		}
		// 수직
		else {
			for (int i = 0; i < key.length; i++) {
				for (int j = 0; j < key.length - 1; j++) {
					if (i+1<key.length && key[i][j] == 1) {
						moveKey[i + 1][j] = 1;
					}
				}
			}
		}
		return moveKey;

	}

	static int[][] padding(int[][] key, int lockSize) {
		int[][] padKey = new int[lockSize + 2 * key.length - 2][lockSize + 2 * key.length - 2];
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				padKey[i][j] = key[i][j];
			}
		}
		return padKey;
	}

	static boolean unlock(int[][] key, int[][] map,int lockSize,int keySize) {
		int[][] addMap = new int[map.length][map.length];

		// 합치기
		for (int i = 0; i < addMap.length; i++) {
			for (int j = 0; j < addMap.length; j++) {
				addMap[i][j] = key[i][j] + map[i][j];
			}
		}
		// 잠금이 풀렸는지 -> lock에 해당하는 부분이 다 1인지
		for (int i = 0; i < lockSize; i++) {
			for (int j = 0; j < lockSize; j++) {
				if(addMap[i + keySize - 1][j + keySize - 1]!=1)
					return false;
			}
		}
		return true;
	}

	static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}