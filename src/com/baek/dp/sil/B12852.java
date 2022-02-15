package com.baek.dp.sil;

import java.io.*;

public class B12852 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N= Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1], before = new int[N+1];
		before[1] = -1;
		for(int i=2;i<=N;i++) {
			arr[i] = arr[i-1] + 1;
			before[i] = i - 1;
			if(i%2==0 && arr[i] > arr[i/2]) {
				arr[i] = arr[i/2] + 1;
				before[i] = i / 2;
			}
			if(i%3==0 && arr[i] > arr[i/3]) {
				arr[i] = arr[i/3] + 1;
				before[i] = i / 3;
			}
		}
		sb.append(arr[N]).append("\n");
		int idx = N;
		while(idx!=-1){
			sb.append(idx).append(" ");
			idx = before[idx];
		}
		
		System.out.println(sb);
	}

}
