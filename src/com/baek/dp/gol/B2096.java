package dp.gol45;

import java.io.*;
import java.util.*;

public class B2096 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] maxDp = new int[3];
		int[] minDp = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());

			if (i == 0) {
				maxDp[0] = minDp[0] = x1;
				maxDp[1] = minDp[1] = x2;
				maxDp[2] = minDp[2] = x3;
			} else {
				int maxd1 = maxDp[0], maxd2 = maxDp[2];
				maxDp[0] = Math.max(maxDp[0], maxDp[1]) + x1;
				maxDp[2] = Math.max(maxDp[1], maxDp[2]) + x3;
				maxDp[1] = Math.max(Math.max(maxd1, maxDp[1]), maxd2) + x2;

				int mind1 = minDp[0], mind2 = minDp[2];
				minDp[0] = Math.min(minDp[0], minDp[1]) + x1;
				minDp[2] = Math.min(minDp[1], minDp[2]) + x3;
				minDp[1] = Math.min(Math.min(mind1, minDp[1]), mind2) + x2;
			}
		}
		sb.append(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + " "
				+ Math.min(minDp[0], Math.min(minDp[1], minDp[2])));
		System.out.println(sb);
		
	}
}
