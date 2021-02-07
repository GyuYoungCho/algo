package com.baek.imple.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B2621 {

	public static int[] color, digit;
	static int max_num, pair;
//	static boolean pair, two pair, triple, four, striaght, flush;
	static Map<String, Integer> state;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		color = new int[4];
		digit = new int[10];
		state = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			char C = st.nextToken().charAt(0);
			int d = Integer.parseInt(st.nextToken());
			if (C == 'R')
				color[0]++;
			else if (C == 'B')
				color[1]++;
			else if (C == 'Y')
				color[2]++;
			else
				color[3]++;
			digit[d]++;
			max_num = Math.max(max_num, d);
		}
		for (int i = 0; i < 4; i++) {
			if (color[i] == 5) {
				state.put("flush",i);
				break;
			}
		}
		for (int i = 0; i < 6; i++) {
			if (digit[i] == 1 && digit[i + 1] == 1 && digit[i + 2] == 1 && digit[i + 3] == 1 && digit[i + 4] == 1) {
				state.put("straight",i);
				break;
			}
		}
		if(state.containsKey("flush")||state.containsKey("straight")) {
			if(state.containsKey("flush") && state.containsKey("straight")) 
				System.out.println(900 + max_num);
			else if(state.containsKey("flush"))
				System.out.println(600 + max_num);
			else if(state.containsKey("straight"))
				System.out.println(500 + max_num);
			return ;
		}
		for (int i = 0; i < 10; i++) {
			if (digit[i] == 2) {
				if(state.containsKey("pair"))
					state.put("two_pair",i);
				else state.put("pair",i);
			}else if(digit[i] == 3) {
				state.put("triple",i);
			}else if(digit[i] == 4) {
				state.put("four",i);
			}
		}
		if(state.containsKey("four")) 
			System.out.println(800 + state.get("four"));
		else if(state.containsKey("triple")) {
			int n = state.containsKey("pair") ? 700+10*state.get("triple") + state.get("pair"): 400 + state.get("triple");
			System.out.println(n);
		}
		else if(state.containsKey("pair")) {
			if(state.containsKey("two_pair")) {
				int min_pair = Math.min(state.get("pair"), state.get("two_pair"));
				int max_pair = Math.max(state.get("pair"), state.get("two_pair"));
				System.out.println(300+10*max_pair + min_pair);
			}else
				System.out.println(200 + state.get("pair"));
		}
		else
			System.out.println(100 + max_num);

	}
}
