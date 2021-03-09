package com.baek.dp.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2294 {

	static int N, K;
	static int [] coin, arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[101];
		coin = new int[N];
		for(int i= 0;i<N;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(cal(K,N));
	}
	static int cal(int k, int n) {
		int min=100000, temp=0;
		if(k<=0) return 0;
		else if(arr[n]>0)
			return arr[n];
		for(int i=0;i<n;i++) {
			temp = cal(k - coin[i],n) + coin[i];
			min = temp < min ? temp : min;
		}
		arr[c] = min;
		return min;
	}

}
