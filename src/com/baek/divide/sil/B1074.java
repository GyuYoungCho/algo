package com.baek.divide.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074 {
	static int N, r, c, cnt=0;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		divide(1<<N, 0, 0);
	}

	private static void divide(int idx, int row, int col) {
		if (row == r && col == c) {
			System.out.println(cnt);
			System.exit(0);
		}
		if (idx == 1) {
			cnt++;
			return;
		}
		if (!inside(row,col,idx)) {
	        cnt += idx * idx;
	        return;
		}
		divide(idx / 2, row, col);
		divide(idx / 2, row, col + idx / 2);
		divide(idx / 2, row + idx / 2, col);
		divide(idx / 2, row + idx / 2, col + idx / 2);
	}
	
	private static boolean inside(int x,int y,int range) {
		return x <=r && y<=c && x+range > r && y+range>c; 
	}
}
