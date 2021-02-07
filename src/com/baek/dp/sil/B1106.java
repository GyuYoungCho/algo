package com.baek.dp.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1106 {
	static int C,N;
	static int [] price,custom, arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[1001];
		price = new int[N];
		custom = new int[N];
		for(int i= 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			price[i] = Integer.parseInt(st.nextToken());
			custom[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(cal(C,N));
	}
	static int cal(int c, int n) {
		int min=100000, temp=0;
		if(c<=0) return 0;
		else if(arr[c]>0)
			return arr[c];
		for(int i=0;i<n;i++) {
			temp = cal(c - custom[i],n) + price[i];
			min = temp < min ? temp : min;
		}
		arr[c] = min;
		return min;
	}
}

