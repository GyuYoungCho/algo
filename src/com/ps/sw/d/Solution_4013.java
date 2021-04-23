package com.ps.sw.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013 {
	static int K;
	static int[][] arr = new int[4][8];
    static int[] ro;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                if(s.charAt(j)=='1') arr[i][j] = 1;
            }
        }
        
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            ro = new int[4];
            process(num, dir);
        }



        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int num = arr[i][0];

            if (num == 1) {
                sum += Math.pow(2, i);
            }
        }
        System.out.println(sum);
    }
	
	private static void process(int num, int dir) {
		ro[num] = dir;
		int d = dir;
		for (int i = num; i >0; i--) {
			if (arr[i-1][2] != arr[i][6]) {
                ro[i-1] = d*=-1;
            }
			else break;
		}
		d = dir;
		for (int i = num; i <3; i++) {
			if (arr[i+1][6] != arr[i][2]) {
				ro[i+1] = d*=-1;
            }
			else break;
		}
		for (int i = 0; i < 4; i++) {
			if(ro[i]!=0) rotate(i);
		}
	}
	private static void rotate(int num) {
		int[] temp = new int[8];

        for (int j = 0; j < 8; j++) {
            int idx = j + ro[num];
            temp[(idx+8)%8] = arr[num][j];
        }
        arr[num] = temp;
	}

}
