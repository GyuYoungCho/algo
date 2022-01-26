package com.baek.backtrack.gol;

import java.io.*;
import java.util.*;

public class B3980 {
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			boolean check[]=new boolean[11];
			max=Integer.MIN_VALUE;
			int playerScore[][]=new int[11][11];
			for(int i=0; i<11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<11; j++) {
					playerScore[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			solve(check,playerScore, 0, 0);
			System.out.println(max);
		}
	}

	private static void solve(boolean [] check, int[][] score, int num, int total) {
		if(num==11) {
			max =Math.max(total, max);
			return;
		}
		
		for(int i=0; i<11; i++) {
			if(score[num][i]==0 || check[i]) continue;
			check[i]=true;
			solve(check, score, num+1, total+score[num][i]);
			check[i]=false;
		}
	}
}
