package com.baek.bisearch.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B20366 {
	static int N;
	static int arr[];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N - 3; i++){
			for (int j = i+3; j < N; j++){
				int elja = arr[i] + arr[j];
				int left = i + 1;
				int right = j - 1;
				
				while (left < right){
					int anna = arr[left] + arr[right];
					
					if (anna < elja) left++;
					else right--;
					
					ans = Math.min(ans, Math.abs(elja - anna));
				}

			}
		}
		System.out.println(ans);
	}

}
