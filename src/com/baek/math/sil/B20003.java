package com.baek.math.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20003 {
	static int N;
	static long arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new long[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
			long gc = gcd(arr[i][0],arr[i][1]);
			arr[i][0]/=gc;
			arr[i][1]/=gc;
		}
		
		long a = arr[0][0];
		long b = arr[0][1];
		for (int i = 1; i < N; i++) {
			a = gcd(a,arr[i][0]);
			b = b*arr[i][1]/ gcd(b,arr[i][1]);
		}
		System.out.println(a +" " +b);
	}
	
	static long gcd(long a, long b) {
		if(a<b) {
			long temp = a;
			a =b;
			b= temp;
		}
		while(b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}
