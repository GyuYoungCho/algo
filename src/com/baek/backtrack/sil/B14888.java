package com.baek.backtrack.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {

	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;	
	public static int[] arr, op = new int[4];
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
 
		dfs(arr[0], 1);
 
		System.out.println(max +"\n" +min);
	}
 
	public static void dfs(int num, int idx) {
		if (idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				if (i==0) dfs(num + arr[idx], idx + 1);
				if (i==1) dfs(num - arr[idx], idx + 1);
				if (i==2) dfs(num * arr[idx], idx + 1);
				if (i==3) dfs(num / arr[idx], idx + 1);
				op[i]++;
			}
		}
	}

}
