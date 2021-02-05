package com.baek.brute.bron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = 9;
		int[] arr = new int[N];
		int sum=0;
		boolean check =false;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		e:for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j)continue;
				if(sum-arr[j]-arr[i]==100) {
					arr[i]=0;
					arr[j]=0;
					break e;
				}
			}
		}
		Arrays.sort(arr);
		for(int i =2;i<9;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}

}
