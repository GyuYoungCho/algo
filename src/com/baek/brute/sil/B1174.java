package com.baek.brute.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1174 {

	static int T, cnt = 0;
	static boolean find = false;
	static int[] dex, num = {9,8,7,6,5,4,3,2,1,0};
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
			for(int j=0;j<11-i;j++) {
				dex[0] = num[j];
				makecom(i, 1);
			}
			if (cnt>T)
				break e;
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list.get(T-1));
	}

	static void makecom(int n, int d) {
		if (n == d) {
			long t =0;
			while(d>0) {
	            t+=dex[dex.length-d]*Math.pow(10,d-1);
	            d-=1;
			}
			list.add(t);
	        cnt++;
			return;
		}
		for (int i = num[dex[d-1]]+1; i <11-n+d ; i++) {
			dex[d] = num[i];
			makecom(n,d+1);
		}
	}
}
