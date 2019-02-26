package Sds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	static int[][] map;
	static boolean[] visit;
	static int n,m,v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 정점의 개수(node)
		m = sc.nextInt(); // 간선의 개수(line)
		v = sc.nextInt(); // 탐색을 시작할 정점의 번호(start)
		
		map = new int[n+1][n+1]; //인접행렬
		visit = new boolean[n+1]; //방문여부
		
		int num1, num2; //간선을 연결하는 두 정점의 번호
		
		for(int i=1; i<=m; i++) {
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			map[num1][num2] = map[num2][num1] = 1;
		}
		
		dfs(v);
		ResetVisit();
		bfs(v);
		
	}
	
	public static void ResetVisit() {
		for(int i=1; i<n+1; i++) {
			visit[i] = false;
		}
		System.out.println();
	}
	
	public static void dfs(int d) {
		visit[d] = true;
		System.out.print(d +" ");
		
		for(int i=1; i<n+1; i++) {
			if(map[d][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
	
	public static void dfs2(int d) {
		Stack<Integer> stack = new Stack<>();
		stack.push(d);
		int p;
		boolean flag;
		
		visit[d] = true;
		System.out.println(d + " ");
		
		while(!stack.isEmpty()) {
			p = stack.peek();
			flag = false;
			
			for(int i=1; i<n+1; i++) {
				if(map[p][i] == 1 & !visit[i]) {
					stack.push(i);
					visit[i] = true;
					System.out.print(i + " ");
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				stack.pop();
			}
		}
	}
	
	public static void bfs(int b) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(b);
		visit[b] = true;
		
		while(!queue.isEmpty()) {
			b = queue.poll();
			System.out.print(b + " ");
			
			for(int i=1; i<n+1; i++) {
				if(map[b][i] == 1 & !visit[i]) {
					queue.offer(i);
					visit[i] = true;
				}
			}
		}
	}
} 
































