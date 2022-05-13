package com.baek.divide.sil;

import java.io.*;
import java.util.*;

public class B24460 {
	static int[][] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(divide(N, 0, 0));
	}
	
	static int divide(int n, int r, int c) {
		if(n==1) return arr[r][c];
		
		int two = n/2;
		int[] ans = new int[4];
		for(int i=0; i<2;i++) {
			for(int j=0; j<2;j++) {
				ans[2*i+j] = divide(two,r + two*i,c + two*j);
			}
		}
		Arrays.sort(ans);
		return ans[1];
	}
}
