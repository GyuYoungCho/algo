package com.baek.imple.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244_스위치 {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, st_num, se, switch_num;
	static boolean [] switches; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		st_num = Integer.parseInt(br.readLine());
		
		String token;
		switches = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			token = st.nextToken();
			switches[i] = token.charAt(0) =='1';
		}
		for(int i=0;i<st_num;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			se = Integer.parseInt(line.nextToken());
			switch_num = Integer.parseInt(line.nextToken());
			
			int can_switch = switch_num;
			if(se==1) {
				while(can_switch <= n) {
					switches[can_switch] = change_switch(switches[can_switch]);
					can_switch+=switch_num;
				}
			}else {
				switches[can_switch] = change_switch(switches[can_switch]);
				int cnt = 1;
				while(can_switch- cnt>=1&&can_switch+cnt<=n) {
					if(switches[can_switch-cnt] == switches[can_switch+cnt]) {
						switches[can_switch-cnt] = change_switch(switches[can_switch-cnt]);
						switches[can_switch+cnt] = change_switch(switches[can_switch+cnt]);
						cnt++;
					}else
						break;
				}
			}
		}
		for(int i=1;i<=n;i++) {
			sb.append(switches[i] ? 1 : 0).append(" ");
			if (i%20==0)
				sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean change_switch(boolean a) {
		return !a;
	}

}
