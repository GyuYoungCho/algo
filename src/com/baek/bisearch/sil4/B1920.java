package com.baek.bisearch.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920 {

	static int N, M, num;
	static int[] A;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(A);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			num = Integer.parseInt(st.nextToken());
			if(bs(num)) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean bs(int num) {
		int start = 0, end = N-1;
		while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] ==num) return true;
            if (A[mid] > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
		return false;
	}

}
