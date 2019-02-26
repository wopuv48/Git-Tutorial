package Sds;

import java.util.HashSet;
import java.util.Scanner;

public class sds1 {
	static int Max;
	static HashSet<Integer> hs;
	static int k;

	public static void main(String[] args) {
		int testCase = 0;
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		
		for(int i=1; i<=testCase; i++) {
			StringBuilder number = new StringBuilder();
			number.append(sc.nextInt());
			k = sc.nextInt();
			hs = new HashSet<>();
			Max = Integer.MIN_VALUE;
			dfs(number,0,0);
			System.out.println("#"+i+" "+ Max);
		}
	}
	
		public static void dfs(StringBuilder num, int depth, int v) {
			int temp = Integer.parseInt(num.toString());
			System.out.println("temp:"+temp);
			String x = new String();
			System.out.println("x:"+x);
			
			if(depth == k) {
				Max = Math.max(Max, temp);
				System.out.println("Max:"+Max);
				return;
			}
			
			if(hs.contains(temp))
				return;
			
			hs.add(temp);
			System.out.println(hs);
			
			for(int i=v; i<num.length(); i++) {
				for(int j=i+1; j<num.length(); j++) {
					x = num.substring(i, i+1);
					num.replace(i, i+1, num.substring(j, j+1));
					num.replace(j, j+1, x);
					System.out.println("x1:"+x);
					System.out.println("num1:"+num);
					
					dfs(num, depth+1, i);
					
					x = num.substring(i, i+1);
					num.replace(i, i+1, num.substring(j, j+1));
					num.replace(j, j+1, x);
					System.out.println("x2:"+x);
					System.out.println("num2:"+num);
					
				}
			}
		}
		
	}


