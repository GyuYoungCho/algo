package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_11446 {
	static int T,N;
	static long M, max=0;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Long.parseLong(st.nextToken());
			arr = new long[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
				max = Math.max(max, arr[i]);
			}
			sb.append("#").append(tc).append(" ").append(max < M?0:bs(1,max)).append("\n");
		}
		System.out.println(sb);
	}
	
	static long bs(long start, long end) {
		long mid, sum;
		while(start<=end) {
			mid = (start+end)/2;
			sum=0;
			for(int i=0; i<N; i++) {
				sum+=arr[i]/mid;
			}
			if(sum<M) {
				end = mid -1;
			}else {
				start = mid+1;
			}
		}
		return start-1;
	}

}
