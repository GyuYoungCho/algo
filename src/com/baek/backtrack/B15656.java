package com.baek.backtrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15656 {
	public static StringBuilder sb = new StringBuilder();
	public static int N, M;
	public static int[] arr, output;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
 
		output = new int[N+1];
		st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            output[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(output);
		arr = new int[M];
		search(0);
		System.out.println(sb);
	}
	
	public static void search(int depth) {
		if(depth == M) {
			for(int i=0;i<M;i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i=1;i<=N;i++) {
			arr[depth] = output[i];
			search(depth+1);
		}
	}
}
