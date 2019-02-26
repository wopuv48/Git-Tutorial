package first;

import java.util.Scanner;

public class firstTest {

	public static void main(String[] args) {
	Scanner st = new Scanner(System.in);
	int n;
	int a;
	
	do { 
		System.out.print("n:");
		n = st.nextInt();
		a = n;
	} while(n <= 0);
	
	for(int i = 1; i<=n; i++) {
		for(int j= a-1; j>0; j--) {
			System.out.print(" ");
		}
		for(int k= i*2-1; k>0; k--) {
			System.out.print("*");
		}
		a--;
		System.out.println();
	}
	}

}
