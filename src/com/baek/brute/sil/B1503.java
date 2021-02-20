package com.baek.brute.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1503 {

	static int N,M , min = Integer.MAX_VALUE;
	static boolean [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new boolean[1003];
		for(int i=0;i<M;i++) {
			arr[Integer.parseInt(st.nextToken())] = true;
		}
		
		for (int i = 1; i < 1001; i++) {
			if (arr[i])continue;
			for (int j = i; j < 1002; j++) {
				if (arr[j])continue;
				for (int k = j; k < 1003; k++) {
					if (arr[k])continue;
					min = Math.min(min, Math.abs(N - i * j * k));
				}
			}
		}
		System.out.println(min);
	}

}
