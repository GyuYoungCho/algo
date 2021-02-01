package com.saffy.algo;

import java.util.Scanner;

public class algo3 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String s1 = scan.next();
		String s2 = scan.next();
		
		int [] arr1 = new int[26];
		int [] arr2 = new int[26];
		int Answer = 0;
		
		for(int i=0;i<s1.length();i++)
			arr1[s1.charAt(i) - 'a']++;
		for(int i=0;i<s2.length();i++)
			arr2[s2.charAt(i) - 'a']++;
		for(int i=0;i< 26;i++)
			Answer+=Math.abs(arr1[i] - arr2[i]);
		
		System.out.println(Answer);
	}
}
