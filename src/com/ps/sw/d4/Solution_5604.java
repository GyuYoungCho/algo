package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5604 {
	static int T;
	static long A, B, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());

			ans = 0;
			long po = 1;
			while (A <= B) {

				while (B % 10 != 9 && A <= B) {
					cal(B, po);
					B--;
				}
				System.out.println(ans);
				if (A > B)
					break;

				while (A % 10 != 0 && A <= B) {
					cal(A, po);
					A++;
				}
				System.out.println(ans);
				A /= 10;
				B /= 10;
				long m = (B - A + 1) * po;
				for (int i = 0; i < 10; i++)
					ans += m * i;
				po *= 10;
			}

			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void cal(long a, long b) {
		while (a > 0) {
			ans += (a % 10) * b;
			a /= 10;
		}
	}
}
