package com.baek.bisearch.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B20366 {
	static int N;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		Arrays.sort(arr);
//		
//		int ans = Integer.MAX_VALUE;
//		for (int i = 0; i < N - 1; i++){
//			for (int j = i; j < N; j++){
//				int snow1 = arr[ i ] + arr[ j ];
//				int left = i + 1;
//				int right = j - 1;
//				
//				while (left < right){
//					int snow2 = arr[ left ] + arr[ right ];
//					if (snow2 < snow1) left++;
//					
//					else right--;
//					
//					ans = Math.min(ans, Math.abs(snow1 - snow2));
//				}
//
//			}
//		}
//		System.out.println(ans);
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				for (int i = 2; i < N; i++) {
					for (int i = 3; i < N; i++) {
						
					}
				}
			}
		}
	}

}
