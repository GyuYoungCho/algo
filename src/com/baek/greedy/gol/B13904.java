package com.baek.greedy.gol;

import java.io.*;
import java.util.*;

public class B13904 {
	static int N, total = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());	
		List<int[]> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new int[] {d,w});
		}
		
		Collections.sort(list, (o1,o2) -> Integer.compare(o2[1], o1[1]));
		
		int[] check = new int[1001];
		for(int[] p : list) {
			for(int i=p[0]; i>0; i--) {
				if(check[i]==0) {
					check[i] = p[1];
					break;
				}
			}
		}
		for(int num : check) {
			total += num;
		}
		System.out.println(total);
	}
}