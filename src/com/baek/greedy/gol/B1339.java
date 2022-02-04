package com.baek.greedy.gol;

import java.io.*;
import java.util.*;

public class B1339 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] arr = new int[26];
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int k = 1;
			for (int j = s.length()-1; j >=0; j--) {
				arr[s.charAt(j)- 'A'] -= k;
				k*=10;
			}
		}
		
		Arrays.sort(arr);
		
		int res = 0;
		for (int i = 0; i < 10; i++) {
			res += -arr[i]*(9-i);
		}
		
		System.out.println(res);
	}	

}
