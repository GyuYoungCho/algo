package com.test;

import java.io.*;
import java.util.*;
class SCO1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int s = 0;
		int max = 2400;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine()," ~ ");
			String start = st.nextToken();
			int stime = Integer.parseInt(start.split(":")[0]) * 100 + 
				Integer.parseInt(start.split(":")[1]);
			String end = st.nextToken();
			int etime = Integer.parseInt(end.split(":")[0]) * 100 + 
				Integer.parseInt(end.split(":")[1]);
				
			s = s<stime?stime:s;
			max = max>etime?etime:max;
		}
		String k1 = s%100 < 10 ? "0" + s%100 : "" +s%100;
		String k2 = max%100 < 10 ?"0" + max%100 :"" +max%100;
		sb.append(s/100).append(":").append(k1).append(" ~ ").append(max/100).append(":").append(k2);
		System.out.println(s<max?sb:-1);
		
	}
}
