package com.baek.string.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		String s = br.readLine();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char a = s.charAt(i);
			if(i==len-1) {
				cnt++;break;
			}
			if (i < len - 2 && a == 'd' && s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=') {
				cnt++;
				i += 2;
			}
			
			
			else if (i < len - 1 &&a == 'c' && (s.charAt(i + 1) == '-' || s.charAt(i + 1) == '=')) {
				cnt++;
				++i;
			} else if (i < len - 1 &&a == 'd' && s.charAt(i + 1) == '-') {
				cnt++;
				++i;
			} else if (i < len - 1 &&(a == 'l' || a == 'n') && s.charAt(i + 1) == 'j') {
				cnt++;
				++i;
			} else if (i < len - 1 &&a == 's' && s.charAt(i + 1) == '=') {
				cnt++;
				++i;
			} else if (i < len - 1 &&a == 'z' && s.charAt(i + 1) == '=') {
				cnt++;
				++i;
			}
			else cnt++;
		}
		System.out.println(cnt);
	}
}
