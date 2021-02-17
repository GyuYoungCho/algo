package com.baek.bisearch.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B20551 {
	static int N, M;
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr);

		for (int i = 0; i < M; i++) {
			sb.append(bs(Integer.parseInt(br.readLine()))).append("\n");
		}
		System.out.println(sb);
	}

	private static int bs(int a) {
		if(a < arr.get(0) || a > arr.get(N-1)) return -1;
		int start = 0, end = N - 1;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			if (arr.get(mid) >= a) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			
		}
		return arr.get(start) == a ? start : -1;
	}
}
