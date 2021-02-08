package com.baek.dp.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B9461 {
	static int[] p = {0,1,1,1,2,2,3,4,5,7,9};
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine()); 
		List<Long> list = new ArrayList<>();
		list.add((long)0);list.add((long)1);list.add((long)1);list.add((long)1);list.add((long)2);
		for(int i=5;i<=100;i++)
			list.add(list.get(i-1) + list.get(i-5));
		for(int i=0;i<T;i++) {
			sb.append(list.get(Integer.parseInt(br.readLine()))).append("\n");
		}
		System.out.println(sb);
	}

}
