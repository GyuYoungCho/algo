package com.baek.dfsbfs.sil12;

import java.io.*;
import java.util.*;

public class B12761 {
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int A,B,N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = stoi(st.nextToken());
		B = stoi(st.nextToken());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		int[] arr = new int[100001];
		arr[N] = 1;
		e:while(!q.isEmpty()){
			int cur = q.poll();
			
			int[] dir = {1, -1,-A, -B, A, B, A, B};		 
			
			for(int i = 0; i < dir.length; i++){
				int next = 0;
				
				if(i < 6)
					next = cur + dir[i];
				else
					next = cur*dir[i];
				
				
				if(next >= 0 && next < 100001){
					if(arr[next] == 0){
						arr[next] = arr[cur] + 1;
						
						if(next == M)
							break e;
						

						q.offer(next);
					}
				}
			}
		}
		
		System.out.println(arr[M]-1);
	}

}
