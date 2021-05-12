package com.baek.math.gol;

import java.io.*;
import java.util.*;

public class B9080 {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(T-->0) {
			int ans=0;
			st = new StringTokenizer(br.readLine());
			String time = st.nextToken();
			int spd = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(time,":");
			int h = (Integer.parseInt(st.nextToken())+2)%24;
			int m = Integer.parseInt(st.nextToken());
		
			while(spd>0) {
				if(h<=4&&spd>300) {
					spd-=(600-(h*60+m));
					h=10;
					m=0;
					ans+=5000;
				}else {
					h = (h+1)%24;
					spd-=60;
					ans+=1000;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
