package com.baek.backtrack.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759 {
	static int N,M;
	static char[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
        
        Arrays.sort(arr);
        
        make(0,0,0,0,"");
        System.out.println(sb);
	}

	static void make(int i, int cnt, int mo, int ja, String s){
        if(cnt==N){
            if(mo>=1 && ja>=2) sb.append(s).append("\n");
            return;
        }
        if(i==M) return;
        if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
            make(i + 1, cnt + 1, mo + 1, ja, s + arr[i]);
        else
            make(i + 1, cnt + 1, mo, ja + 1, s + arr[i]);
        make(i+1, cnt, mo, ja, s);
    }

}
