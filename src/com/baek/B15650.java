package com.baek;

// n과 m 1 포함
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650 {

	public static StringBuilder sb = new StringBuilder();
	public static int N, M;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		search(0,1);
		System.out.println(sb);
	}

	public static void search(int end,int start) {
		if (end == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = start; i <= N; i++) { 
			arr[end] = i;
			search(end + 1,i);
		}
	}

}
