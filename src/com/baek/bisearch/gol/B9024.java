package com.baek.bisearch.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9024 {
	static int T,N,K, min , ans;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			ans = 0;
			min  = Integer.MAX_VALUE;
			for(int i=0;i<N-1;i++) {
				int left = i+1;
				int right = N-1;
				while(left <= right) {
					int mid = (left+right)/2;
					int sum = arr[i] + arr[mid];
					
					if(sum < K) {
						left = mid+1;
					}else {
						right = mid-1;
					}
					
					if(Math.abs(sum-K) < min) {
						ans = 1;
						min = Math.abs(sum-K);
					}else if(Math.abs(sum-K) == min) {
						ans++;
						
					}
				}
				
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
