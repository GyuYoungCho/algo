package com.programmers.summer;

import java.util.*;

public class Test2 {

	public static void main(String[] args) {
		int[] t = {0,1,3,0,2,2,2,2,2};
		int[] r = {0,1,2,1,2,1,2,1,0};
		System.out.println(Arrays.toString(solution(t,r)));
	}
	public static int[] solution(int[] t, int[] r) {
		int[] answer = {};
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            return Integer.compare(o1[0],o2[0]);
        });
        
        PriorityQueue<int[]> wait = new PriorityQueue<>((o1,o2) -> {
            if(o1[1]==o2[1] && o1[0]==o2[0]) return Integer.compare(o1[2],o2[2]);
            if(o1[1]==o2[1]) return Integer.compare(o1[0],o2[0]);
            return Integer.compare(o1[1],o2[1]); 
        });
        
        ArrayList<Integer> list = new  ArrayList<>();
        
        int max=0;
        for(int i=0;i<t.length;i++){
            pq.offer(new int[]{t[i],r[i],i});
        }
//        for(int i=0;i<t.length;i++){
//            System.out.println(Arrays.toString(pq.poll()));
//        }
        
        int time=0;
        
        while(!pq.isEmpty()){
            while(!pq.isEmpty() && pq.peek()[0]==time)
                wait.offer(pq.poll());
            
            if(!wait.isEmpty()) {
                int[] cur = wait.poll();
                list.add(cur[2]);
            }            
            time++;
        }
        while(!wait.isEmpty()) {
            int[] cur = wait.poll();
            list.add(cur[2]);
        }
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
	}
	public static boolean inside(int x, int y) {
		return x<0||y<0||x>6||y>6;
	}
}
