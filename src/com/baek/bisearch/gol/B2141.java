package com.baek.bisearch.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2141 {
	static int N;
	static long max = 3000000000L;
	static long[] arr , three = new long[3];
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<N-2;i++) {
			int left = i+1;
			int right = N-1;
			while(left < right) {
				long sum = arr[i] + arr[left] + arr[right];
				
				if(Math.abs(sum) < max) {
					three[0] = arr[i];
					three[1] = arr[left];
					three[2] = arr[right];
					max = Math.abs(sum);
				}
				
				if(sum>0) right--;
				else left++;
			}
			
		}
		
		System.out.println(three[0]+" "+three[1]+" "+three[2]);
		
	}

}
