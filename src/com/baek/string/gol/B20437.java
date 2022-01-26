package com.baek.string.gol;

import java.io.*;
import java.util.*;

public class B20437 {
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int T,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = stoi(br.readLine());
		
		for (int t=0; t<T; t++) {
			char[] str = br.readLine().toCharArray();
			K = stoi(br.readLine());
			
			int max = -1, min = 10001;
			
			ArrayList<Integer> list[] = new ArrayList[26];
			for (int i=0; i<26; i++) list[i] = new ArrayList<>();
			
			for (int i=0; i<str.length; i++) {
				list[str[i]-'a'].add(i);
			}
			
			for (int i=0; i<26; i++) {
				if (list[i].size() < K) continue;
				
				for (int j=0; j<=list[i].size()-K; j++) {
					int diff = list[i].get(j+K-1) - list[i].get(j) + 1;
					max = Math.max(max, diff);
					min = Math.min(min, diff);
				}
			}
			
			if (max == -1) sb.append(-1);
			else sb.append(min).append(" ").append(max);
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
