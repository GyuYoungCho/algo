package com.baek.brute.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961 {
	static int T;
	static int[][] arr;
	static long Min = Long.MAX_VALUE;
	static boolean[] select;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		arr = new int[T][2];
		select = new boolean[T];
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		subsets(0);
		System.out.println(Min);
		
	}
	static void subsets(int cnt) {
		if(cnt==T) {
			
			long sum=0,mul=1;
			for(int i=0;i<T;i++) {
				if(select[i]) {
					sum+=arr[i][1];
					mul*=arr[i][0];
				}
			}
			
			if(sum!=0)
				Min = Math.min(Min, Math.abs(sum-mul));
			return;
		}
		
		select[cnt] = true;
		subsets(cnt+1);
		select[cnt] = false;
		subsets(cnt+1);
	}

}
