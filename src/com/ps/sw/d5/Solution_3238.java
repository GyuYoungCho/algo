package com.ps.sw.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3238 {
	static long N, R;
	static long[] arr;
	static int T,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			R = Long.parseLong(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new long[M];
            arr[0] = 1;
            for (int i = 1; i < M; i++) {
                arr[i] = arr[i - 1] * i % M;
            }
            
            long ans=1;
            while(N>0 || R>0){
                long a=N%M;
                long b=R%M;
                if(a<b) { 
                	ans=0;
                	break;
                }
                ans*=arr[(int)a];
                ans%=M;
                ans*=pow((arr[(int)b]*arr[(int)a-(int)b])%M, M-2);
                ans%=M;
                N/=M;
                R/=M;
            }
            sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	public static long pow(long a, long p) {
        long ans=1;
        while(p>0){
            if((p&1)==1){
                ans*=a;
                ans%=M;
            }
            a*=a;
            a%=M;
            p/=2;
        }
        return ans;
    }
}
