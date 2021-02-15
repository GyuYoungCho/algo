package com.ps.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808 {
	static int N,T, cnt=0, mid = 85;
	static final int TOTAL = 9*8*7*6*5*4*3*2;
	static boolean[] card ,isSelect;
	static int[] gyu , ing;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= T; tc++) {
			card = new boolean[19];
			isSelect = new boolean[9];
			gyu = new int[9];ing = new int[9];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<9;i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				card[gyu[i]] = true;
			}
			for(int i = 1, t=0; i<=18;i++) {
				if(!card[i]) ing[t++] = i;
			}
			
			cnt=0;
			permutation(0,0,0);
			sb.append("#").append(tc).append(" ").append(cnt).append(" ").append(TOTAL-cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void permutation(int idx, int sum1, int sum2) {
		if(sum1 > mid || sum2 > mid) {
			int other = 1;
				for(int i = 2; i<=9-idx;i++ ) {
					other*=i;
				}
				if(sum1>sum2) cnt+=other;
			return;
		}
		for(int i=0;i<9;i++) {
			if(isSelect[i]) continue;
			isSelect[i] = true;
			if(gyu[idx]>ing[i]) {
				permutation(idx+1, sum1 + ing[i] + gyu[idx], sum2);
			}else {
				permutation(idx+1, sum1 , sum2 + ing[i] + gyu[idx]);
			}
			isSelect[i] = false;
		}
	}
	
}
