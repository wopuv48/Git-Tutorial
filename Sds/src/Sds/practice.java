package Sds;

import java.util.LinkedList;
import java.util.Queue;

public class practice {
	
	public static void main(String[] args) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {1, 2, 3, 5});
//		queue.offer(new int[] {1});
		int a = queue.peek()[0];
//		int b = queue.peek()[1];
		queue.poll();
		
		System.out.println(queue.isEmpty());
		// TODO Auto-generated method stub

	}

}
