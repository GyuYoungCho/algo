package com.baek.backtrack.sil;

import java.io.*;
import java.util.*;

public class B10819 {
	static int T, arr[];
	static boolean visit[];
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[T];
		
		for (int i = 0; i < T; i++) arr[i] = stoi(st.nextToken());
		int max = 0;
        for (int i = 0; i < T; i++) {
        	visit = new boolean[T];
        	visit[i]= true;
            max = Math.max(max, comb(arr[i]));
        }
        System.out.println(max);
	}
	
	private static int comb (int cur) {
        int sum = 0;
        for (int i = 0; i < T; i++) {
            if (visit[i]) continue;
            visit[i]= true;
            sum = Math.max(sum, comb(arr[i]) + Math.abs(cur - arr[i]));
            visit[i]= false;
        }
        return sum;
    }
}
