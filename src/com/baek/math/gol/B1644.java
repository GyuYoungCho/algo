package com.baek.math.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1644 {
	static int N;
	static boolean arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N+1];
		List<Integer> prime = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			if (!arr[i]) {
				prime.add(i);
				for (int j = i + i; j <= N; j += i) {
					arr[j] = true;
				}
			}
		}
		
		int sum=0,ans=0,end=0;
		for (int s = 0; s < prime.size(); s++) {
			while (end < prime.size() && sum < N) {
				sum += prime.get(end++);
			}
			if (sum == N) ans++;
			sum -= prime.get(s);
		}
		System.out.println(ans);
	}

}
