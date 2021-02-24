package com.baek.imple.bron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2601 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(-1);
		for(int i = 1 ; i < N+1 ; i++) {
			int target = Integer.parseInt(st.nextToken());
			arr.add(i-target,i);
		}
		
		
		for(int i = 1 ; i < N +1 ; i++) {
			sb.append(arr.get(i)+ " ");
		}
		System.out.println(sb);
	}

}
