package nqueen;

import java.util.Scanner;

public class nqueen {
	
	static int[] col;
	static int n;
	static int ans;
	
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();
	
	for(int i = 1; i<= n; i++) {
		col = new int[16];
		col[1] = i;
		dfs(2);
	}
	
	System.out.println(ans);
	}
	
	static void dfs(int row) {
		if(row > n) {
			++ans;
		} else {
			for(int i=1; i<=n; i++) {
				col[row] = i;
				
				if(isPossible(row)) {
					dfs(row+1);
				} else {
					col[row] = 0;
				}
			}
		}
	}
	
	static boolean isPossible(int c) {
		
			for(int i=1; i<c; i++) {
				if(col[i] == col[c]) {
					return false;
				}
				if(Math.abs(col[i]-col[c])== Math.abs(i-c)) {
					return false;
				}
			}
			return true;
		}
	}

