package com.baek.imple.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2559 {
	static int N, M,max, sum=0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max+=arr[i];
		}
		sum=max;
		
		for(int i=M;i<N;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
			sum+=arr[i];
			sum-=arr[i-M];
			if(max < sum) max = sum;
		}
		System.out.println(max);
	}

}
