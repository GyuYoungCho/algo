package com.baek.dp.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1003 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		List<Integer> zero = new ArrayList<>();
		List<Integer> one = new ArrayList<>();
		for(int i=0;i<2;i++) {
			zero.add(1-i);
			one.add(i);
		}
		int T = Integer.parseInt(br.readLine());
		int max =1;
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			if(max < N) {
				for(int k=max+1;k<=N;k++) {
					
					zero.add(zero.get(k-1) + zero.get(k-2));
					one.add(one.get(k-1) + one.get(k-2));
				}
				max = N;
			}
			sb.append(zero.get(N)).append(" ").append(one.get(N)).append("\n");
		}
		System.out.println(sb);
	}

}
