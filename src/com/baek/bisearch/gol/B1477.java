package com.baek.bisearch.gol;

import java.io.*;
import java.util.*;

public class B1477 {
	static int N,M,K;
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		
		arr.add(0);
		arr.add(K);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr.add(stoi(st.nextToken()));
		}
		
		Collections.sort(arr);
		
		int left = 1, right = K;
		while(left <= right) {
			int mid = (left+right)/2;
			int sum = 0;
			
			for (int i = 1; i < N+2; i++) {
				sum+= (arr.get(i) - arr.get(i-1)-1) / mid;
			}
			if(sum <= M) right = mid-1;
			else left = mid+1;
		}
		System.out.println(left);
	}
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
