package com.baek.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1592 {
	
	static int N, M, L,cnt=0;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		int start = 1;
		arr[1] = 1;
		while(true) {
			start = (arr[start] % 2 == 1) ? (start + L) : start - L; 
			if(start > N) start %= N;	
			else if(start < 1) start += N;
			
			arr[start]++;	
			cnt++;	
			if(arr[start] == M)
				break;
		}
		System.out.println(cnt);
	}

}
