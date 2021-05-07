package com.baek.sort;

import java.io.*;
import java.util.*;

public class B10814 {
	static int N;
	static String[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new String[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				arr[i][j] = st.nextToken();
			}
		}
		
		Arrays.sort(arr,(o1,o2)->{
			return Integer.compare(Integer.parseInt(o1[0]),Integer.parseInt(o2[0]));
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		System.out.println(sb);
	}

}
