package com.saffy.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2577 {
	static int N,D,K,C,max;
	static int[] arr, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N+K];
		count = new int[D+1];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(i<K) {
				count[arr[i]]++;
				if(count[arr[i]]==1) cnt++;
			}
		}
		
		for (int i = 1; i < N; i++) {
			if(max<=cnt)
				max = count[C] ==0? cnt+1:cnt;
			
			count[arr[i-1]]--;
			if(count[arr[i-1]]==0) cnt--;
			if(count[arr[(i-1+K)%N]]==0) cnt++;
			count[arr[(i-1+K)%N]]++;
		}
		
		System.out.println(max);
	}

}
