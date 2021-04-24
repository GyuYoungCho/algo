package com.test.mo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2 {
	static int N;
	static int[][] arr, arr2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			arr2 = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				if(arr[0][i]==0) continue;
				if(arr[0][i]==arr[1][i]) continue;
				simulate(i);
				
			}
			
			int ans1=0,ans2=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr2[i][j] = arr[N-j-1][i];
				}
			}
			arr = arr2;
			
			for (int i = 0; i < N; i++) {
				if(arr[0][i]==0) continue;
				if(arr[0][i]==arr[1][i]) continue;
				simulate(i);
			}
			for (int i = 0; i < N; i++) {
				if(arr[i][0]==1) ans1++;
			}
			for (int i = 0; i < N; i++) {
				if(arr[N-1][i]==1) ans2++;
			}
			sb.append(ans1).append(" ").append(ans2).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void simulate(int line) {
		List<Integer> list = new ArrayList<>();
		int cnt=1;
		for (int i = 1; i < N; i++) {
			if(arr[i][line]!=arr[i-1][line]) {
				list.add(cnt);
				cnt = 1;
			}else cnt++;
		}
		list.add(cnt);
		int K  = list.size()/2;
		double pre = list.get(0);
		int empty = 0, size = 1, idx = -1;
		for (int i = 0; i < K; i++) {
			double str = pre * Math.pow(1.9,list.get(2*i+1));
			empty+=list.get(2*i+1);
			if(2*i+2 >= list.size()) {
				break;
			}
			size+=list.get(2*i+2);

			if(str<list.get(2*i+2)) {
				idx = i;
				break;
			}
			pre = str+list.get(2*i+2);
			
		}
		
		for (int i = 0; i < empty; i++) {
			arr[i][line] = 0;
		}
		for (int i = empty; i < empty+size; i++) {
			arr[i][line] = 1;
		}
	}

}
