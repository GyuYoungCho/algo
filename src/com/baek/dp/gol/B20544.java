package com.baek.dp.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B20544 {
	static int T, MOD = 1000000007;
	static long[][][] arr, exps;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		//i는 위치, j는 전꺼<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  
		arr= new long[T+1][3][3];
		for(long first[][]:arr) {
			for(long second[]:first) {
				Arrays.fill(second, -1L);
			}
		}
		exps= new long[T+1][2][2];
		for(long first[][]:exps) {
			for(long second[]:first) {
				Arrays.fill(second, -1L);
			}
		}
		
		long all = (solve(T - 1, 0, 0) + solve(T - 1, 1, 0) + solve(T - 1, 2, 0)) % MOD;
		long excep = (exception(T - 1, 0, 0) + exception(T - 1, 1, 0)) % MOD;
		System.out.println((excep)%MOD);
	}
	
	
	private static long solve(int n, int now, int before) {
		if (arr[n][now][before] != -1)
			return arr[n][now][before];
		
		if (n == 0){
			if (now == 0)
				arr[n][now][before] = 1;
			else
				arr[n][now][before] = 0;
			return arr[n][now][before];
		}

		if (now == 0){
			return (solve(n - 1, 2, now) + solve(n - 1, 1, now) + solve(n - 1, 0, now))%MOD;
		}
		else if (now == 1){
			if (before == 0)
				return (solve(n - 1, 2, now) + solve(n - 1, 1, now) + solve(n - 1, 0, now))%MOD;
			else
				return solve(n - 1, 0, now)%MOD;
		}
		else if (now == 2){
			if (before == 0)
				return (solve(n - 1, 1, now) + solve(n - 1, 0, now))%MOD;
			else if (before == 1)
				return solve(n - 1, 0, now)%MOD;
		}
		return arr[n][now][before]%MOD;
	}

	
	private static long exception(int n, int now, int before) {
		
		if (exps[n][now][before] != -1)
			return exps[n][now][before];
		
		if (n == 0)
		{
			if (now == 0)
				exps[n][now][before] = 1;
			else
				exps[n][now][before] = 0;
			return exps[n][now][before];
		}

		if (now == 0){
			return (exception(n - 1, 1, now) + exception(n - 1, 0, now)) % MOD;
		}
		else if (now == 1){
			if (before == 0)
				return (exception(n - 1, 1, now) + exception(n - 1, 0, now)) % MOD;
			else if (before == 1)
				return exception(n - 1, 0, now) % MOD;
		}
		return exps[n][now][before]%MOD;
	}
	
//	private static long solve(int n, int h, int next, int two) {
//		if (arr[n][h][next][two] != -1)
//			return arr[n][h][next][two];
//		
//		if (n == 0){
//			if (h == 0) 
//				arr[n][h][next][two] = 1;
//			return arr[n][h][next][two];
//		}
//
//
//		if (h == 0){
//			return (solve(n - 1, 2, h,1) + solve(n - 1, 1, h,two) + solve(n - 1, 0, h,two))%MOD;
//		}
//		else if (h == 1){
//			if (next == 0)
//				return (solve(n - 1, 2, h, 1) + solve(n - 1, 1, h, two) + solve(n - 1, 0, h,two))%MOD;
//			else
//				return solve(n - 1, 0, h, two)%MOD;
//		}
//		else if (h == 2){
//			if (next == 0)
//				return (solve(n - 1, 2, h, 1) + solve(n - 1, 1, h,two) + solve(n - 1, 0, h,two))%MOD;
//			else if(next ==1)
//				return solve(n - 1, 0, h,two)%MOD;
//		}
//		return 0;
//	}

}
