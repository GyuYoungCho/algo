package com.ps.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_1873 {

	static int H, W, N, direct, x, y, newx, newy;
	static char[][] field;
	static char[] work;
	static int[][] delta = { { 0, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } }; // LRUD

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			field = new char[H][W];
			direct = 0;
			
			for (int i = 0; i < H; i++)
				field[i] = br.readLine().toCharArray();
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (field[i][j] == '<' || field[i][j] == '>' || field[i][j] == '^' || field[i][j] == 'v') {
						x = i;
						y = j;
						if (field[i][j] == '<')
							direct = 1;
						else if (field[i][j] == '>')
							direct = 2;
						else if (field[i][j] == '^')
							direct = 3;
						else
							direct = 4;
					}
				}
			}

			N = Integer.parseInt(br.readLine());
			work = br.readLine().toCharArray();

			for (int i = 0; i < N; i++) {
				char c = work[i];
				newx = x;
				newy = y;
				if(c == 'L' || c == 'R' || c == 'U' || c =='D') {
					if(c == 'L') {
						direct = 1;
						field[x][y] = '<';
					} else if(c == 'R') {
						direct = 2;
						field[x][y] = '>';
					} else if(c == 'U') {
						direct = 3;
						field[x][y] = '^';
					} else{
						direct = 4;
						field[x][y] = 'v';
					}
					newx += delta[direct][0];
					newy += delta[direct][1];
					
					if(inside(newx, newy) && field[newx][newy] == '.') {
							field[newx][newy] = field[x][y];
							field[x][y] = '.';
							x = newx; 
							y = newy;
					}
					
				}else {
					while(true) {
						newx += delta[direct][0];
						newy += delta[direct][1];
						if(!inside(newx, newy) || field[newx][newy] == '#') break;
						else if(field[newx][newy] == '*') {
							field[newx][newy] = '.';
							break;
						}
					}
				}
			}

			sb.append("#").append(t).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}

	public static boolean inside(int r, int c) {
		return r>= 0 && r < H && c >= 0 && c < W;
	}

	static String src = "1\r\n" + "3 7\r\n" + "***....\r\n" + "*-..#**\r\n" + "#<.****\r\n" + "23\r\n"
			+ "SURSSSSUSLSRSSSURRDSRDS";
}
