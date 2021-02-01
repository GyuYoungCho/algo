package com.baek.recur.sil5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B16505 {

	static char[][] map;
    static int N, length;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		int length = (int)Math.pow(2, N);
		map = new char[length][length];
		for (int i=0; i<length; i++) 
			Arrays.fill(map[i], ' ');
		
		recursive(0, 0, 0);
		
		for (int i=0; i<length; i++) { 
			for (int j=0; j<length-i; j++) 
				sb.append(map[i][j]); 
			if (i!=length-1)
				sb.append("\n"); 
		}
		System.out.print(sb);

	}

	public static void recursive(int d, int x, int y) {
        if (d == N) {
            map[y][x] = '*';
            return;
        }
        int depth = (int)Math.pow(2, d);
        recursive(depth+1, x, y);
        recursive(depth+1, x+d, y);
        recursive(depth+1, x, y+d);
    }
	
}
