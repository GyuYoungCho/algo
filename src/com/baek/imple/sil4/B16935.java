package com.baek.imple.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16935 {
	static int N, M, R, nx, ny, temp, value;
	static int[][] arr, arr1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 1)
				one();
			else if (num == 2)
				two();
			else if (num == 3)
				three();
			else if (num == 4)
				four();
			else if (num == 5)
				five();
			else if (num == 6)
				six();
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void one() {
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[arr.length - 1 - i][j];
				arr[arr.length - 1 - i][j] = temp;
			}
		}
	}

	static void two() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length /2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr[0].length - 1 - j];
				arr[i][arr[0].length - 1 - j] = temp;
			}
		}
	}

	static void three() {
		arr1 = new int[arr[0].length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr1[j][arr.length - 1 - i] = arr[i][j];
			}
		}
		arr = arr1;
	}

	static void four() {
		arr1 = new int[arr[0].length][arr.length];
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr1[i][j] = arr[j][arr[0].length - 1 - i];
			}
		}
		arr = arr1;
	}

	static void five() {
		arr1 = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[0].length / 2; j++) {
				arr1[i][j + arr[0].length / 2] = arr[i][j];
			}
		}

		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = arr[0].length / 2; j < arr[0].length; j++) {
				arr1[i + arr.length / 2][j] = arr[i][j];
			}
		}

		for (int i = arr.length / 2; i < arr.length; i++) {
			for (int j = arr[0].length / 2; j < arr[0].length; j++) {
				arr1[i][j - arr[0].length / 2] = arr[i][j];
			}
		}

		for (int i = arr.length / 2; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length / 2; j++) {
				arr1[i - arr.length / 2][j] = arr[i][j];
			}
		}

		arr = arr1;
	}

	static void six() {
		arr1 = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[0].length / 2; j++) {
				arr1[i + arr.length / 2][j] = arr[i][j];
			}
		}

		for (int i = arr.length / 2; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length/2; j++) {
				arr1[i][j + arr[0].length / 2] = arr[i][j];
			}
		}

		for (int i = arr.length / 2; i < arr.length; i++) {
			for (int j = arr[0].length / 2; j < arr[0].length; j++) {
				arr1[i - arr.length / 2][j] = arr[i][j];
			}
		}

		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = arr[0].length / 2; j < arr[0].length; j++) {
				arr1[i][j-arr[0].length/2] = arr[i][j];
			}
		}

		arr = arr1;
	}

}
