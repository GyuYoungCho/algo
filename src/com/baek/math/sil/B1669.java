package com.baek.math.sil;

import java.io.*;
import java.util.*;

public class B1669 {
	static int N,M;
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dif = stoi(st.nextToken()) * (-1) + stoi(st.nextToken());
		int s = (int)Math.sqrt(dif);
		int day = 0;
		while(s>0) {
			dif-=s;
			if(Math.sqrt(dif) < s) s--;
			day++;
		}
		System.out.println(day);
		
	}

}
