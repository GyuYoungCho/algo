package com.baek.dfsbfs.sil3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @since
 * @author rbud613
 * @see : https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV19AcoKI9sCFAZN&probBoxId=AXdbYpUKxsoDFAUO+&type=PROBLEM&problemBoxTitle=0201&problemBoxCnt=++1+#none
 * @mem
 * @time
 * @caution
 */

public class B2606_바이러스 {
	
	static ArrayList<Integer>[] a;
    static boolean[] visit;
    static int count;
    
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		a = new ArrayList[n+1]; 
		visit = new boolean[n+1];
		
		for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			a[start].add(end);
			a[end].add(start);
		}
		count=0;
		search(1);
		System.out.println(count);
	}
	public static void search(int x) {  
	        visit[x] = true;
	        for (int y : a[x]) {
	            if (visit[y] == false) {
	            	count++;
	                search(y);
	            }
	        }
	    }

}
