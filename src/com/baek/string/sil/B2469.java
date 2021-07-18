package com.baek.string.sil;

import java.io.*;
import java.util.*;

public class B2469 {
	static int K,N;
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static char[] in,out;
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		K = stoi(br.readLine());
		N = stoi(br.readLine()); 

		char[] in = new char[K];
		for (int i = 0; i < K; i++) {
			in[i] = (char) (i + 65);
		}

		out = br.readLine().toCharArray();
		arr = new char[N][K];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
			if (arr[i][0] == '?') idx = i;
		}
		
		for (int i = 0; i < idx; i++) {
			for (int j = 0; j < K - 1; j++) {
				if (arr[i][j] == '-') swap(in, j);
			}
		}

		for (int i = N - 1; i > idx; i--) {
			for (int j = 0; j < K - 1; j++) {
				if (arr[i][j] == '-') swap(out, j);
			}
		}
		
		char[] ans = new char[K-1];
		boolean flag = false;
		for (int i = 0; i < K-1; i++) {
			if (in[i] == out[i]) {
				ans[i] = '*';
			} else if (in[i] == out[i + 1] && in[i + 1] == out[i]) {
				ans[i] = '-';
				swap(in, i);
			} else {
				flag = true;
				break;
			}
		}

		if (flag) Arrays.fill(ans, 'x');
		for (int i = 0; i < K-1; i++) {
			sb.append(ans[i]);
		}
		System.out.println(sb);
	}
	private static void swap(char[] a, int i) {
		char temp;
		temp = a[i];
		a[i] = a[i + 1];
		a[i + 1] = temp;
	}
}
