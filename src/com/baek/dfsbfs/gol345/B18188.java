package com.baek.dfsbfs.gol345;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B18188 {
	static int H, W, N;
	static char[][] arr;
	static char[][] command;
	static int[][] delta = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static int[] d;
	static boolean flag, ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		arr = new char[H][W];
		for (int i = 0; i < H; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				if (arr[i][j] == 'D') {
					d = new int[] {i,j};
				}
			}
		}
		
		N = Integer.parseInt(br.readLine());
		command = new char[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			command[i][0] = st.nextToken().charAt(0);
			command[i][1] = st.nextToken().charAt(0);
		}
		
		dfs(0,d[0],d[1], new ArrayList<>());
		// key를 저장하기 위한 list
		System.out.println(ans?sb:"NO");
	}

	private static void dfs(int start, int r, int c, List<Character> list) {
		for (int i = start; i < N; i++) {
			flag = false;
			for (int j = 0; j < 2; j++) {
				int dir = keydir(command[i][j]);
				int x = r + delta[dir][0];
				int y = c + delta[dir][1];

				if (inside(x, y) && arr[x][y] != '@') {
					list.add(command[i][j]);
					flag = true;
					// 찾을 경우 바로 결과 출력, ans를 이용해 모두 종료
					if (arr[x][y] == 'Z') {
						sb.append("YES").append("\n");
						for (int k = 0; k < list.size(); k++) {
							sb.append(list.get(k));
						}
						ans = true;
						return;
					} else {
						// 다음꺼 탐색
						dfs(i + 1, x, y, list);
						if(ans) return;
						list.remove(list.size() - 1);
						flag = false;
					}
				}
				if(ans) return;
			}
			// 끝까지 탐색했는데 찾지 못함
			if(!flag) return;
		}
	}

	// 입력받은 키를 index로 변환
	private static int keydir(char c) {
		int result = 0;
		if (c == 'W') {
			result = 0;
		} else if (c == 'A') {
			result = 1;
		} else if (c == 'S') {
			result = 2;
		} else if (c == 'D') {
			result = 3;
		}
		return result;
	}

	public static boolean inside(int x, int y) {
		return x >= 0 && y >= 0 && x < H && y < W;
	}
}
