package com.baek.bisearch.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1477 {
	static int T,N,M,K;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+2];
			
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[0] = 0;
		arr[N+1] = K;
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = K;
		while(left <= right) {
			int mid = (left+right)/2;
			int sum = 0;
			
			for (int i = 1; i < N+2; i++) {
				sum+=(arr[i] - arr[i-1]-1) / mid;
			}
			if(sum <= M) {
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		System.out.println(left);
	}
}
