package com.baek.brute.bron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3040 {
	static boolean end = false;
	static int[] arr, arr1 = new int[9];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt=0;
		for(int i=0;i<9;i++) {
			int k = Integer.parseInt(br.readLine());
			if(k<=94) {cnt++;arr1[i]=k;}
		}
		arr = new int[cnt];
		for(int i=0,t=0;i<9;i++) {
			if(arr1[i]!=0) {
				arr[t++]=arr1[i];
			}
		}
		arr1 = new int[7];
		Bitpermutation(0, 0);
		for(int s: arr1) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void Bitpermutation(int cnt, int flag) {
		if(cnt==7) {
			int sum = 0;
			for(int s: arr1) {
				sum+=s;
			}
			if(sum==100) end= true;
			return;
		}
		for(int i=0;i<9;i++) {
			if((flag & 1<<i) != 0) continue;
			arr1[cnt] = arr[i];
			Bitpermutation(cnt+1, flag|1<<i);
			if(end) return;
		}
	}
}
