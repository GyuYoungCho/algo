package com.baek.greedy.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399 {
	static int N;
	static int[] cal;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		cal = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cal);
		int sum = 0;
		for(int i=N;i>0;i--) {
			sum+=i*cal[N-i];
		}
		System.out.println(sum);
	}

}
