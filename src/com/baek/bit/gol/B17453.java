package com.baek.bit.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class B17453 {
	static int N,M;
	static int door[], switches[][];
	static ArrayList<Integer>[] list;
	static boolean check[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		door = new int[N];
		switches = new int[M][N];
		list = new ArrayList[2*N+1];
		check = new boolean[2*N+1];
		
		for (int i = 0; i < 2*N+1; i++) {
            list[i] = new ArrayList<>();
        }
		
		String str = br.readLine();
		for (int i = 0; i < N; i++) {
			if(str.charAt(i)=='1') door[i] = 1;
			else door[i]=-1;
		}
		
		for (int i = 0; i < M; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				if(str.charAt(j)=='0') switches[i][j] = 1;
				else switches[i][j]=-1;
			}
		}
		
		for (int i = 0; i < (1 << M); i++) {
			ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                if ((i & 1 << j) > 0) { 
                    subset.add(j);
                }
            }
            find(subset);
        }
		
		for (int i = 0; i < 2*N+1; i++) {
            if(!check[i]) sb.append(-1).append("\n");
            else {
            	sb.append(list[i].size()+" ");
            	for (int j = 0; j < list[i].size(); j++) {
					sb.append(list[i].get(j) +" ");
				}
            	sb.append("\n");
            }
        }
		System.out.println(sb);
		
	}

	static void find(ArrayList<Integer> subset) {
        int[] temp = new int[N];
        temp = door.clone();
        for (int i = 0; i < subset.size(); i++) {
            for (int j = 0; j < temp.length; j++) {
                temp[j] *= switches[subset.get(i)][j];
            }
        }
        int result = 0;
        for (int i = 0; i < temp.length; i++) {
            result += temp[i];
        }
        if (!check[result + N]) {
            for (int i = 0; i < subset.size(); i++) {
                list[result + N].add(subset.get(i) + 1);
            }
            check[result + N] = true;

        }

    }
}
