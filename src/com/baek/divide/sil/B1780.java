package com.baek.divide.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1780 {
	static int N;
	static int[] count = new int[3];
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		for(int i=0; i<3;i++) {
			sb.append(count[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void divide(int r, int c, int range) {
		if(isSame(r,c,range)) {
			count[arr[r][c]+1]++;
			return;
		}
		
		int three = range/3;
		for(int i=0; i<3;i++) {
			for(int j=0; j<3;j++) {
				divide(r + three*i,c + three*j,three);
			}
		}
	}
	
	private static boolean isSame(int r, int c, int range) {
		int one = arr[r][c];
		for(int i=r; i<r+range;i++) {
			for(int j=c; j<c+range;j++) {
				if(arr[i][j]!=one) return false;
			}
		}
		return true;
	}
}
