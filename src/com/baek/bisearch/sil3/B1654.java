package com.baek.bisearch.sil3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1654 {
	static int N, M, cnt = 0;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		long max = 0;
		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}
		binarySearch(1,max);
	}
	
	private static void binarySearch(long start, long end) {
        long mid = 0;
        while (start <= end) {
        	int cnt = 0;
        	
            mid = (start + end) / 2;
            for(int i =0;i<N;i++) {
            	cnt+=arr[i]/mid;
            }
            if (cnt < M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start-1);
    }
}
