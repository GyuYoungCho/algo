package com.saffy.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1205 {
	
	static int N,max, zero_cnt, min = Integer.MAX_VALUE;
	static int[] arr;
	static Queue<Integer> q= new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		st= new StringTokenizer(br.readLine());

		arr= new int[N];
		for(int i=0;i<N;i++) {
			int k =Integer.parseInt(st.nextToken());
			arr[i]=k;
			if(k==0) zero_cnt++;
		}
		
		Arrays.sort(arr);
		int [] arr1 = new int[N+1];
		arr1[0] = arr[0] - zero_cnt >= 0 ? arr[0] : zero_cnt;
		for(int i=1;i<N;i++) {
			arr1[i] = arr[i] - arr[i-1] - 1;
		}
		
		arr1[N] = arr[N-1] + zero_cnt >1000000?1000000:zero_cnt;
		
		
		for(int i=zero_cnt+1;i<N+1;i++) {
			int stra = 0;
			int div = zero_cnt;
			int j = i;
			while(div>=0&&j<N+1) {
				j++;
				if(arr1[j-1]==-1) continue;
				stra++;
				if(arr1[j-1]==0) continue;
				if(arr1[j-1]  <= div) {
					stra+=arr1[j-1];
					div-=arr1[j-1];
				}else {
					stra+=div;
					break;
				}
			}
//			stra+=div;
			max = max < stra ? stra : max;
			
		}
		
		System.out.println(max);
	}
	
}
