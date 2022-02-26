package com.baek.bisearch.gol;

import java.io.*;
import java.util.*;

public class B2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++)
            arr.add(Integer.parseInt(st.nextToken()));
        
        Collections.sort(arr);
        
        int start = 0, end = n-1, m1=0, m2=0, val = Integer.MAX_VALUE;
 
        while(start < end) {
            
            int v1 = arr.get(start);
            int v2 = arr.get(end);
            
            if(Math.abs(v1+v2) < val) {
                val = Math.abs(v1+v2);
                m1 = start; m2 = end;
            }
            
            if(v1 + v2 < 0) start++;
            else end--;
        }
        System.out.println(arr.get(m1)+" " + arr.get(m2));
	}
}
