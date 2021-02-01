package com.baek;

import java.util.Scanner;

public class B2615 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[][] deltas = {{ 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
		int[][] game = new int[19][19];
		int win = 0;
		boolean five = false;
		int newx, newy;

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				game[i][j] = scan.nextInt();
			}
		}
		scan.close();

		all:for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (game[i][j] > 0) {
					win = game[i][j];
					for (int k = 0; k < 4; k++) {
						if (isIn(i - deltas[k][0], j - deltas[k][1]) && game[i - deltas[k][0]][j - deltas[k][1]] == win)
							continue;
						for (int l = 1; l <= 4; l++) {
							newx = i + l * deltas[k][0];
							newy = j + l * deltas[k][1];
							if (!isIn(newx, newy) || game[newx][newy] != win) {
								five = false;
								break;
							}
							five = true;
						}
						if(five) {
							if(!isIn(i + 5* deltas[k][0], j + 5 * deltas[k][1] ) || (game[i + 5* deltas[k][0]][j + 5 * deltas[k][1]] != win)) {
								if(k==3)
									System.out.printf("%d\n%d %d",win,i+5,j-3);
								else
									System.out.printf("%d\n%d %d",win,i+1,j+1);
								break all;
							}
						}
						five = false;
					}
				}
				win = 0;
			}
		}
		
		if(win==0)
			System.out.printf("%d",win);
	}

	static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < 19 && nc >= 0 && nc < 19;
	}
}
