package com.baek.bisearch.gol;

import java.io.*;
import java.util.*;

public class B2470 {
	static int N,max = 2000000000;
	static int[] arr , two = new int[2];
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			if(Math.abs(sum) < max) {
				two[0] = arr[left];
				two[1] = arr[right];
				max = Math.abs(sum);
			}
			
			if(sum>0) right--;
			else left++;
		}
		System.out.println(two[0]+" "+two[1]);
		
	}
}
