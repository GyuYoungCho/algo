package com.baek.bit.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17453 {
	static int N,M;
	static char[] door;
	static char[] oper;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		door = new char[N];
		oper = new char[N];
		for (int i = 0; i < N; i++) {
			
		}
		door = br.readLine().toCharArray();
		for (int i = 0; i < M; i++) {
			oper = br.readLine().toCharArray();
		}
	}

}