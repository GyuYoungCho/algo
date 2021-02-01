package com.saffy.algo;

import java.util.Scanner;

public class algori {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();

		int[][] arr1 = new int[6][2];

		for (int i = 0; i < N; i++) {
			int s = scan.nextInt();
			int g = scan.nextInt();
			arr1[g-1][s]++;
		}
		int Answer = 0;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				if(arr1[i][j]==0)
					continue;
				if(arr1[i][j]==1) {
					Answer+=1;
					continue;
				}
				Answer += (arr1[i][j]-1)/K + 1;
			}
		}
		
		System.out.println(Answer);
	}
}
