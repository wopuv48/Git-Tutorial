package Observation;

import java.util.Scanner;

public class observation {
	static final int INF = 987654321;
	
	static int N, M;
	static int[][] Map = new int[8][8];
	static int CamCnt;
	static int[] CamType = new int[8];
	static int[] CamRow = new int[8];
	static int[] CamCol = new int[8];
	static int[] Dr = {0, -1, 0, 1}; //0-right, 1=up, 2=left, 3=down
	static int[] Dc = {1, 0, -1, 0};
	static int[][] Dcam = {
			{1, 0, 0, 0, 4},
			{1, 0, 1, 0, 2},
			{1, 1, 0, 0, 4},
			{1, 1, 1, 0, 4},
			{1, 1, 1, 1, 1}
	};
	
	static void watch(int r, int c, int dir) {
		int srow = r, scol = c;
		for(;;) {
			int nr = srow + Dr[dir], nc = scol +Dc[dir];
			if(nr <0 || nr > N-1 || nc<0 || nc>M-1) return;
			if(Map[nr][nc] == 6) return;
			Map[nr][nc] = 7;
			srow = nr;
			scol = nc;
		}
		
	}
	
	static void copymap(int[][] dst, int[][] src) {
		for(int i=0; i<N; ++i)
			for(int j=0; j<M; ++j)
				dst[i][j] = src[i][j];
	}
	
	static int solve(int pos) {
		
		if (pos == CamCnt) { //sovle()함수 안에 숫자가 캠의 갯수와 똑같다면, 사각지대의 최소크기 0의 개수를 센다.
			int sum = 0;
			for(int i=0; i<N; ++i)
				for(int j=0; j<M; ++j)
					if(Map[i][j] == 0) ++sum;
		    return sum;
		}
		
		int[][] backup = new int[8][8]; //copy 할 백업지도.
		int ret = INF; //0의 최대 갯
		int type = CamType[pos] - 1; //앞전에 CamType[CamCnt] 에 카메라 번호가 저장 됨.Dcam[type][]의 type에 따라 카메라번호가 나눠지기 때문에 카메라 번호에 맞춰주기 위해서 -1
		
		for(int i=0; i<Dcam[type][4]; ++i) { //카메라 번호 따라 90도 회전할때 경우의수 모두를 해봄.
			copymap(backup, Map); //백업 맵에 맵을 복
			
			for(int j=0; j<4; ++j) { //0~3
				if(Dcam[type][j] == 1) {
					watch(CamRow[pos], CamCol[pos], (i+j) % 4);
				}
			ret = Math.min(ret,  solve(pos+1));
				
			copymap(Map, backup);
		}
			
		}
		return ret;
	}
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		CamCnt = 0;
		
		for(int i=0; i<N; ++i) {
			for(int j=0; j<M; ++j) {
				Map[i][j] = sc.nextInt();
				if(Map[i][j] >= 1 && Map[i][j] <= 5) {
					CamType[CamCnt] = Map[i][j];
					CamRow[CamCnt] = i;
					CamCol[CamCnt++] = j;
				}
			}
		}
		System.out.println(CamCnt);
		System.out.println(solve(0));
	}
}
