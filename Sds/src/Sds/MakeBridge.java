package Sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MakeBridge {
	public static int SIZE;
	public static int[][] danji;
	public static boolean[][] visited;
	
	public static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SIZE = Integer.parseInt(br.readLine());
		
		danji = new int[SIZE][SIZE];
		visited = new boolean[SIZE][SIZE];
		
		pq = new PriorityQueue<Integer>();
		
		for(int i=0; i<SIZE; i++) {
			String str = br.readLine();
			for(int j=0; j<SIZE; j++) {
				danji[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(danji[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(pq.size());
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x, y});
		
		int count = 0;
		while(!queue.isEmpty()) {
			int currentX = queue.peek()[0];
			int	currentY = queue.peek()[1];
			queue.poll();
			
			
			System.out.println(queue.isEmpty());
			
			if(currentX < 0 || currentY < 0 || currentX >= SIZE || currentY >= SIZE) continue;
			
			if(danji[currentX][currentY] == 0) continue;
			
			if(visited[currentX][currentY]) continue;
			
			count += 1;
			visited[currentX][currentY] = true;
			
			queue.offer(new int[] {currentX+1, currentY});
			queue.offer(new int[] {currentX-1, currentY});
			queue.offer(new int[] {currentX, currentY-1});
			queue.offer(new int[] {currentX, currentY+1});
		}
		
		pq.offer(count);
	}
}