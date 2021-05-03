package com.baek.bisearch.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1756 {
	static int N,M,next = Integer.MAX_VALUE;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i] = Math.min(next, arr[i]);
			next = arr[i];
		}
		int left=0,right = N;
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			
//			while(left<right) {
//				int mid = (left+right)/2;
//				if(arr[mid]<now) right = mid-1;
//				else left=mid+1;
//			}
			while(right>0 && arr[right]<now) {
				right--;
			}
			right--;
			if(right<0) break;
			
		}
		System.out.println(right<0?0:right+1);
	}

}
