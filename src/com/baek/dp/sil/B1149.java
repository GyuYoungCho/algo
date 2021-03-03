package com.baek.dp.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//이전 값의 최소를 다음 값에 계속 더해주기
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] += Math.min(arr[i-1][(j+1)%3], arr[i-1][(j+2)%3]);
			}
		}
		System.out.println(Math.min(Math.min(arr[N-1][0], arr[N-1][1]),arr[N-1][2]));
	}
}
