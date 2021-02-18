package com.baek.brute.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1038 {

	static int T, cnt = 0;
	static boolean find = false;
	static int[] dex;
	static List<Long> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		if(T>=1024) {
			System.out.println(-1);
			return;
		}
		e:for (int i = 1; i <= 10; i++) {
			dex = new int[i];
			makecom(i, 0,0);
			
			if (cnt>T)
				break e;
		}
		Collections.sort(list);
		System.out.println(list.get(T-1));
	}

	static void makecom(int n, int c, int d) {
		if (n == c) {
			long t =0;
			while(c>0) {
	            t+=dex[c-1]*Math.pow(10,c-1);
	            c-=1;
			}
			list.add(t);
	        cnt++;
			return;
		}
		for (int i = d; i < 10 ; i++) {
			dex[c] = i;
			makecom(n,c+1,i+1);
		}
	}
}
