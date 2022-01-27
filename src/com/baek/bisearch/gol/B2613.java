package com.baek.bisearch.gol;

import java.io.*;
import java.util.*;

public class B2613 {
	static int N,M;
	static int[] arr,box;
	static int si(String s) {
        return Integer.parseInt(s);
    }
	
	static boolean possible(int mid) {
        int start = 0, cnt = 1;
        for (int i = 0; i < N; i++) {
            start += arr[i];
            if (start > mid) {
                start = arr[i];
                cnt++;
            }
        }
        return cnt <=M;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = si(st.nextToken());
		M = si(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		int left=1,right=0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = si(st.nextToken());
			left = left < arr[i] ? arr[i] : left;
			right += arr[i];
		}
		
		while(left <=right) {
			int mid = (left+right)/2;
			if(possible(mid)) right = mid -1;
			else left = mid+1;
		}
		sb.append(left).append("\n");
		
		int sum = 0, cnt=0;
		for (int i=0; i < N; i++) {
	        sum += arr[i];
	        if (sum > left) {
	            sum = arr[i];
	            M--;
	            sb.append(cnt).append(" ");
	            cnt = 0;
	        }
	        cnt++;
	        if (N - i == M) break;
	    }

		while (M-->0){
			sb.append(cnt).append(" ");
		    cnt = 1;
		}
		System.out.println(sb);	
	}
}
