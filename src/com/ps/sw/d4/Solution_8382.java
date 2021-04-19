package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8382 {
	static int T,x1,x2,y1,y2,ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);
            int d = Math.abs(dx - dy);
            ans = 2*Math.min(dx, dy) + 2*d;
 
            if(d % 2 != 0) ans -= 1;
            sb.append(ans + "\n");
		}
		System.out.println(sb);
	}

}
