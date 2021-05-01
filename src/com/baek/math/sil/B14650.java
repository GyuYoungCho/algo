package com.baek.math.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14650 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		arr[2] = 2;
		for (int i = 3; i <= N; i++) {
			arr[i] = arr[i-1]*3;
		}
		System.out.println(arr[N]);
	}

}
