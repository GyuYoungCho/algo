package com.baek.imple.gol45;

import java.io.*;
import java.util.*;

public class B14719 {
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static int N,M,left,right,ans, arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr= new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = stoi(st.nextToken());
		}
		
		for(int i = 1; i < M - 1; i++) {
	      left = right = 0;
	      for(int j = 0; j < i; j++) {
	        left = Math.max(arr[j], left);
	      }
	      
	      for(int j = i + 1; j < M; j++) {
	        right = Math.max(arr[j], right);
	      }
	      
	      if(arr[i] < left && arr[i] < right) {
	        ans += Math.min(left, right) - arr[i];
	      }
	    }

	    System.out.println(ans);
	}
}
