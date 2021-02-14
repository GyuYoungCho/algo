package com.baek.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B1269 {
	static int N, M,cnt=0;
	static int [] A;
	static Set<Integer> set1 = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			set1.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < N; i++) {
			if (set1.contains(A[i])) {cnt++;}
		}
		System.out.println(N+M-(cnt*2));
	}

}
