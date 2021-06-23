package com.baek.string.gol;

import java.io.*;
import java.util.*;

public class B2866 {
	static int R,C;
	static char[][] arr;
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		int left = 0, right = R-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			HashSet<String> set = new HashSet<>();
			boolean flag = false;
			
			e:for (int i = 0; i < C; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = mid; j < R; j++) {
					sb.append(arr[j][i]);
				}
				if(set.contains(sb.toString())) {
					flag = true;
					break e;
				}
				set.add(sb.toString());
			}
			
			if(flag) right = mid-1;
			else left = mid+1;
		}
		
		System.out.println(left-1);
	}
}
