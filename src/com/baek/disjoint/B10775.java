package com.baek.disjoint;

import java.io.*;

public class B10775 {
	public static int g, p;
    public static int[] parent;
    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());

        parent = new int[g + 1];

        for (int i = 0; i <= g ; i++) {
            parent[i] = i;
        }
        
        int count = 0;
        for (int i = 0; i < p ; i++) {
            int now = Integer.parseInt(br.readLine());
            
            int p = find(now);
            if(p != 0){
                union(p, p - 1);
                count++;
            }
            else break;
        }
        
        System.out.println(count);
    }
    
    
    public static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    public static void union(int x, int y) {
        x = find(x);
        parent[x] = find(y);  	
    }
}
