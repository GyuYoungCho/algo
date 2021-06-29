package com.baek.dp.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5582 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int max = 0;
        int[][] arr = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); ++i){
            for (int j = 0; j < b.length(); ++j){
                if (a.charAt(i) == b.charAt(j)){
                    if (i == 0 || j == 0)
                        arr[i][j] = 1;
                    else {
                        arr[i][j] = arr[i-1][j-1] + 1;
                    }
                    max = Math.max(max, arr[i][j]);
                }
            }
        }
        System.out.println(max);
    }

}
