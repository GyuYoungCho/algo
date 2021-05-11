package com.baek.math.gol;

import java.io.*;
import java.util.*;

public class B9080 {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-->0) {
			int ans=0;
			st = new StringTokenizer(br.readLine());
			String time = st.nextToken();
			int spd = Integer.parseInt(st.nextToken());
			ans+=(spd/1440)*19000;
			spd%=1440;
			st = new StringTokenizer(time,":");
			int cur = Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
		
			while(spd>0) {
				
			}
		
		}
	}

}
