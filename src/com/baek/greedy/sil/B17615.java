package com.baek.greedy.sil;

import java.io.*;

public class B17615 {
	static int N;
	static char[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		int r = 0;
		
		for (int i = 0; i < N; i++) {
			if (arr[i] == 'R') r++;
		}
		
		if (r == N || r == 0) {
			System.out.println(0);return;
		}
		
		int blue = N - r;
		int min = 500000;
		int cnt = 0;
		int idx = 0;
		while (arr[idx++] == 'R') {
			cnt++;
		}
		min = Math.min(min, r - cnt);
		cnt = 0;
		idx = N - 1;
		while (arr[idx--] == 'R') {
			cnt++;
		}
		min = Math.min(min, r - cnt);
		cnt = 0;
		idx = 0;
		while (arr[idx++] == 'B') {
			cnt++;
		}
		min = Math.min(min, blue - cnt);
		cnt = 0;
		idx = N - 1;
		while (arr[idx--] == 'B') {
			cnt++;
		}
		min = Math.min(min, blue - cnt);
		
		System.out.println(min);
	}
	
}
