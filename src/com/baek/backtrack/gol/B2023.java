package com.baek.backtrack.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2023 {
	static StringBuilder sb = new StringBuilder();
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		int[] arr = {2,3,5,7};
		for(int i=0;i<4;i++) {
			dfs(1,arr[i]);
		}
		System.out.println(sb);
	}

	private static void dfs(int cnt, int sosu) {
		if(cnt==T) {
			sb.append(sosu).append("\n");
			return;
		}
		for(int i=1;i<10;i+=2) {
			int nnum = sosu*10+i;
			if(!isCut(nnum)) continue;
			dfs(cnt+1,nnum);
		}
	}
	private static boolean isCut(int a) {
		int n = (int) Math.sqrt(a);
		for (int i = 2; i <= n; i++) {
	        if (a % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
}
