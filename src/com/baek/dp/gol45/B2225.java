package com.baek.dp.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class B2225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][K+1];
		for (int i = 1; i <= K; i++) {
			arr[0][i] = 1;
		}
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				arr[j][i] = (arr[j-1][i] + arr[j][i-1])%1000000000;
			}
		}
		System.out.println(arr[N][K]);
	
	}

}

// 1111111111
// 123456789
// 136