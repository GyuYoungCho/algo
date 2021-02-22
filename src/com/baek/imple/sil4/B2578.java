package com.baek.imple.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2578 {
	static int[][] arr = new int[5][5];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		e:for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				int k =Integer.parseInt(st.nextToken());
				f:for(int r=0;r<5;r++) {
					for(int c=0;c<5;c++) {
						if(arr[r][c]==k) {
							arr[r][c] = 0;
							break f;
						}
					}
				}
				if(bingo()) {
					System.out.println(5*i+j + 1);
					break e;
				}
			}
		}
	}
	private static boolean bingo() {
		int cnt=0;
		for (int i = 0; i < 5; i++){
			int sum = 0;
			for (int j = 0; j < 5; j++)
				sum += arr[i][j];
			if (sum == 0) cnt++;
		}
		
		for (int i = 0; i < 5; i++){
			int sum = 0;
			for (int j = 0; j < 5; j++)
				sum += arr[j][i];
			if (sum == 0) cnt++;
		}
		
		int sum = 0;
		for (int i = 0; i < 5; i++)
			sum += arr[i][i];
		if (sum == 0) cnt++;

		sum = 0;
		for (int i = 0; i < 5; i++)
			sum += arr[i][5 - 1 - i];
		if (sum == 0) cnt++;
		
		if(cnt < 3) return false;
		return true;
	}
}
