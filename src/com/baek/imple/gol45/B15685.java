package com.baek.imple.gol45;

import java.io.*;
import java.util.*;

public class B15685 {
	
    static boolean[][] map = new boolean[101][101];
    static int N;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
 
        while (N-- > 0) {
        	st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
 
            draw(x, y, getDirections(d, g));
        }
 
        System.out.println(getNumberOfSquares());
    }
 
    public static List<Integer> getDirections(int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);
 
        while (g-- > 0) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                int direction = (directions.get(i) + 1) % 4;
                directions.add(direction);
            }
        }
        return directions;
    }
 
    public static void draw(int x, int y, List<Integer> directions) {
        map[x][y] = true;
 
        for (int direction : directions) {
            switch (direction) {
                case 0:
                    map[++x][y] = true;
                    break;
                case 1:
                    map[x][--y] = true;
                    break;
                case 2:
                    map[--x][y] = true;
                    break;
                case 3:
                    map[x][++y] = true;
                    break;
            }
        }
    }
 
    private static int getNumberOfSquares() {
        int count = 0;
 
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if (map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1])
                    count++;
            }
        }
 
        return count;
    }

}
