package com.baek.backtrack.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663 {

	static int N, count = 0;
	static int[] field;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for(int i=0;i<N;i++) {
			field = new int[N];
			field[0] = i;
			queen(i, 0);
		}
		System.out.println(count);
	}

	static void queen(int x, int y) {
		for(int i =0;i<y;i++){
			if(field[i]==x||Math.abs(i-y)==Math.abs(field[i]-x))
				return;
		}
		if(y==N-1) {
			count++;
			return;
		}
		for(int i =0;i<N;i++){
            field[y+1] = i;
            queen(i,y+1); 
		}
	}
}
