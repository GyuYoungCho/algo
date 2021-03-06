package com.baek.bit.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B13915 {
	static int N;
	static String l;
	static int let = (1 << 10) - 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		while((l=br.readLine())!=null && !l.equals("")) {
			N = Integer.parseInt(l);
			Set<Integer> s = new HashSet<>();
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				String b = br.readLine();
				for (char c : b.toCharArray()) {
					arr[i] |= 1 << (c - 'a');
				}
				
			}
			
			for(int i=0;i<N;i++) {
				s.add(arr[i]);
			}
			sb.append(s.size()).append("\n");
			
		}
		System.out.println(sb);
	}

}
