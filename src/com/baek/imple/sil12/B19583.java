package com.baek.imple.sil12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B19583 {

	static int cnt = 0;
	static int[] time = new int[3];
	static StringTokenizer st, st1;

	public static void main(String[] args) throws IOException {
		int h=0, m=0;
		String rename=new String(), line=new String();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine(), " ");
		Map<String, Boolean> map = new HashMap<>();
		
		for (int i = 0; i < 3; i++) {
			st1 = new StringTokenizer(st.nextToken(), ":");
			h = Integer.parseInt(st1.nextToken());
			m = Integer.parseInt(st1.nextToken());
			time[i] = calTime(h,m);
		}
		
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line, " ");
			st1 = new StringTokenizer(st.nextToken(), ":");
			h = Integer.parseInt(st1.nextToken());
			m = Integer.parseInt(st1.nextToken());

			if (calTime(h, m)<=time[0]) {
				map.put(st.nextToken(), false);
			}else {
				rename = st.nextToken();
				break;
			}
		}

		if (calTime(h, m)< time[1]) {
			while ((line = br.readLine()) != null && calTime(h, m)< time[1]) {
				st = new StringTokenizer(line, " ");
				st1 = new StringTokenizer(st.nextToken(), ":");
				h = Integer.parseInt(st1.nextToken());
				m = Integer.parseInt(st1.nextToken());
				rename = st.nextToken();
			}
		}
		if (calTime(h, m)>= time[1] && calTime(h, m)<= time[2] && map.containsKey(rename)) {
			cnt++;
			map.put(rename, true);
		}
		
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line, " ");
			st1 = new StringTokenizer(st.nextToken(), ":");
			h = Integer.parseInt(st1.nextToken());
			m = Integer.parseInt(st1.nextToken());
			if (calTime(h, m)>= time[1] && calTime(h, m)<= time[2]) {
				rename = st.nextToken();
				if (map.containsKey(rename) && !map.get(rename)) {
					cnt++;
					map.put(rename, true);
				}
			}else {
				break;
			}
		}
		System.out.println(cnt);
	}
	
	static int calTime(int hour, int min) {
		return hour*60 + min;
	}

}
