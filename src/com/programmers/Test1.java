package com.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Test1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> s = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine(),", ");
		int [] arr = new int[26];
		for(int i=0;i<10;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int t=0;
		for(int i=0;i<10;i++) {
			int size = s.size();
			s.add(arr[i]);
			if(size!=s.size()) t++;
		}
		s.clear();
		int[] result = new int[t];
		for(int i=0,j=0;i<5;i++) {
			int size = s.size();
			s.add(arr[i]);
			if(size!=s.size()) {
				result[j++] = arr[i];
			}
		}
		System.out.println(Arrays.toString(result));
//		String s = br.readLine();
//        StringBuilder sb = new StringBuilder();
//        int [] arr = new int[26];
//        for(char a : s.toCharArray()) {
//        	if(a < 90) {
//        		arr[a-'a' + 32]++;
//        	}else {
//        		arr[a - 'a']++;
//        	}
//        }
//        int max=0;
//        for(int i=0;i<26;i++) {
//        	max = Math.max(max, arr[i]);
//        }
//        
//        for(int i=0;i<26;i++) {
//        	if(arr[i]==max) {
//        		sb.append((char)(i+65));
//        	}
//        }
        
//        System.out.println(sb);
	}

}
