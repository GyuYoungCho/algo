package com.ps.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607 {
	static int T,N,K,mod = 1234567891;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new long[N + 1];
            
            arr[0] = 1;
            for (int i = 1; i <= N; i++) {
                arr[i] = arr[i - 1] * i % mod;
            }
            
            long a = arr[K]*arr[N-K] % mod;
            long b = pow(a, mod - 2);
            long ans = arr[N] * b % mod;
            sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	public static long pow(long a, long p) {
		if (p == 0)
            return 1;
		long res = pow(a, p / 2)%mod;
		long res1 = res*res % mod;
        return p%2==0?res1:res1*a%mod;
    }
}
