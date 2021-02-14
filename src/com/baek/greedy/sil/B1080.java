package com.baek.greedy.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1080 {
	static int N, M,cnt=0;
	static boolean [][] A, B;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = getMatrix(A);
		B = getMatrix(B);
		
		if (N < 3 || M < 3) {
	        System.out.println(isSame() ? cnt : -1);
	        return ;
	    }
		
		for(int i=0;i<N-2;i++) {
			for(int j=0;j<M-2;j++) {
				if(A[i][j] ^ B[i][j]) {
					cnt += change(i,j);
				}
			}
		}
		System.out.println(isSame() ? cnt : -1);
	}

	private static boolean[][] getMatrix(boolean[][] getM) throws IOException{
		getM = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String b = br.readLine();
			for(int j=0;j<M;j++) {
				getM[i][j] = b.charAt(j) == '1' ? true : false;
			}
		}
		return getM;
	}
	
	private static boolean isSame() {
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            if (A[i][j] != B[i][j]) 
	            	return false;
	        }
	    }
	    return true;
	}
	
	private static int change(int row, int col) {
	    for (int i = row; i < row + 3; i++) {
	        for (int j = col; j < col + 3; j++) {
	            A[i][j] = !A[i][j];
	        }
	    }
	    return 1;
	}

}
