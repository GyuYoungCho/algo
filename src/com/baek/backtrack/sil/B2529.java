package com.baek.backtrack.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2529 {
	static int N;
	static char[] arr;
	static List<String> num = new ArrayList<>();
	static boolean[] visit = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new char[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		search(0, new String());

		Collections.sort(num);
		System.out.println(num.get(num.size() - 1) +"\n" + num.get(0));
	}

	private static void search(int cnt, String sb) {
		if (cnt == N + 1) {
			num.add(sb);
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!visit[i] && (cnt == 0 || check(sb.charAt(cnt - 1) - '0', i, arr[cnt - 1]))) {
				visit[i] = true;
				search(cnt + 1, sb + i);
				visit[i] = false;
			}
		}
	}

	private static boolean check(int prior, int idx, char op) {
		if (op == '<' && prior > idx)
			return false;
		if (op == '>' && prior < idx)
			return false;
		return true;
	}

}
