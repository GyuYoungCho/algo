package com.baek.imple.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B11559 {
	static char arr[][] = new char[12][6];
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		for (int i = 0; i < 12; i++) { 
			String temp = br.readLine(); 
			for (int j = 0; j < 6; j++) { 
				arr[i][j] = temp.charAt(j); 
			} 
		}
		
		int count = 0;
		boolean flag = true; 
		while (flag) {
			flag = false; 
			for (int i = 0; i < 12; i++) { 
				for (int j = 0; j < 6; j++) { 
					if (arr[i][j] != '.') { 
						ArrayList<int[]> list = find(i, j); 
						if (list.size() >= 4) { 
							for (int k = 0; k < list.size(); k++) {
								int[] ind = list.get(k); 
								arr[ind[0]][ind[1]] = '.'; 
							} 
							flag = true; 
						}
					}
				}
			}
			
			if (flag) { 
				count++; 
				down(); 
			} 
		}	
		System.out.println(count);
	}
	
	private static ArrayList<int[]> find(int x, int y) {
		ArrayList<int[]> list = new ArrayList<>(); 
		Queue<int[]> q = new LinkedList<>(); 
		q.add(new int[] {x,y}); 
		char temp = arr[x][y]; 
		boolean[][] check = new boolean[12][6]; 
		check[x][y] = true; 
		while (!q.isEmpty()) { 
			int[] node = q.poll(); 
			list.add(node);
			for (int i = 0; i < 4; i++) {
				int nx = node[0] + delta[i][0];
				int ny = node[1] + delta[i][1]; 
				if (notin(nx, ny)) continue;
				if (arr[nx][ny] == temp && !check[nx][ny]) { 
					q.add(new int[] {nx, ny}); 
					check[nx][ny] = true;
				} 
			} 
		}
		return list; 
	}

	private static void down() {
		Stack<Character> stack = new Stack<>(); 
		for (int j = 0; j < 6; j++) { 
			for (int i = 0; i < 12; i++) { 
				if (arr[i][j] != '.') 
					stack.push(arr[i][j]); 
				} 
			for (int i = 11; i >= 0; i--) { 
				if (stack.isEmpty()) arr[i][j] = '.'; 
				else arr[i][j] = stack.pop(); 
			} 
		}

	}

	private static boolean notin(int x, int y) { 
		 return x < 0 || x >= 12 || y < 0 || y >= 6; 
	}

}
