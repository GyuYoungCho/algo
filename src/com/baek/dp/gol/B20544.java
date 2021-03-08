package com.baek.dp.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20544 {
	static int T, MOD = 1000000007;
	static long[][][] arr, exps;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		//i는 전전꺼 높이, j는 전꺼 k는 현재 높이
		arr= new long[T+1][3][3];
		exps= new long[T+1][2][2];
		long all = (solve(T - 1, 0, 0) + solve(T - 1, 1, 0) + solve(T - 1, 2, 0)) % MOD;
		long excep = (exception(T - 1, 0, 0) + exception(T - 1, 1, 0)) % MOD;
		System.out.println((all - excep)%MOD);
	}
	
	
	private static long solve(int n, int h, int next) {
		if (n < 0)
			return 0;
		if (arr[n][h][next] != 0)
			return arr[n][h][next];
		
		if (n == 0){
			if (h == 0) 
				arr[n][h][next] = 1;
			else
				arr[n][h][next] = 0;
			return arr[n][h][next];
		}


		if (h == 0)
		{
			return (solve(n - 1, 2, h) + solve(n - 1, 1, h) + solve(n - 1, 0, h))%MOD;
		}
		if (h == 1)
		{
			if (next == 0)
				return (solve(n - 1, 2, h) + solve(n - 1, 1, h) + solve(n - 1, 0, h))%MOD;
			if (next == 1 || next == 2)
				return solve(n - 1, 0, h)%MOD;
		}
		if (h == 2)
		{
			if (next == 2)
				return 0;
			if (next == 1)
				return solve(n - 1, 0, h)%MOD;
			if (next == 0)
				return (solve(n - 1, 1, h) + solve(n - 1, 0, h))%MOD;
		}
		return arr[n][h][next]%MOD;
	}


	private static long exception(int n, int h, int next) {
		if (n < 0)
			return 0;
		if (exps[n][h][next] != 0)
			return exps[n][h][next];
		
		if (n == 0){
			if (h == 0) 
				exps[n][h][next] = 1;
			else
				exps[n][h][next] = 0;
			return exps[n][h][next];
		}

		if (h == 0)
		{
			return (exception(n - 1, 1, h) + exception(n - 1, 0, h)) % MOD;
		}
		if (h == 1)
		{
			if (next == 0)
				return (exception(n - 1, 1, h) + exception(n - 1, 0, h)) % MOD;
			if (next == 1)
				return exception(n - 1, 0, h) % MOD;
		}
		return exps[n][h][next]%MOD;
	}

}
