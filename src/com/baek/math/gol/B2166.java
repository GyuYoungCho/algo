package com.baek.math.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2166 {
	static int N;
	static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		long ans=0;
		for (int i = 2; i < N; i++) {
			ans+=dis(arr[0],arr[i],arr[i-1]);
		}
		ans = Math.abs(ans);
		System.out.println(ans%2==0?ans+".0":ans+".5");
		
	}
	private static long dis(int[] a, int[] b, int[] c) {
		return ((a[0]*b[1]) + (b[0]*c[1]) + (c[0] * a[1])) - ((a[1]*b[0]) + (b[1]*c[0]) + (c[1]*a[0]));
	}

}
