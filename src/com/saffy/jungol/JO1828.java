package com.saffy.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO1828 {
	
	static int N,cnt=0;
	static int[][] refri;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		refri = new int[N][2];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			refri[i][0] = Integer.parseInt(st.nextToken());
			refri[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(refri,(o1,o2) -> {
			int diff = o1[1] - o2[1];
			return diff!=0?diff:o1[0] - o2[0];
		});
		int start = refri[0][1];
		for(int i=1;i<N;i++) {
			if(start < refri[i][0]) {
				cnt++;
				start = refri[i][1];
			}
		}
		System.out.println(cnt+1);
	}

}
