package com.baek.pointer.gol;

import java.util.*;
import java.io.*;

public class B1806 {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0, sum = 0, ans = 100001;
		while(end <= N) {
            if(sum >= M) ans = Math.min(ans,end - start);
            
            if(sum < M) sum += arr[end++];
            else sum -= arr[start++];
        }
		if(ans == 100001) System.out.println(0);
		else System.out.println(ans);
	}
}
