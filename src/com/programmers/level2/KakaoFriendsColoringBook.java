package com.programmers.level2;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 오픈채팅방 문제(level 2)
 * 문자열 파싱 및 map, list 활용
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 *
 */
public class KakaoFriendsColoringBook {
    public static void main(String[] args) {

    }
    private static class Solution {
        public int dx[] = {-1, 1, 0, 0};
        public int dy[] = {0, 0, -1, 1};
        public int front , rear;
        public int q[][] = new int[101][2]; // x,y 좌표 저장
        public int v[][] = new int[101][101]; // 탐색여부 저장

        public int[] solution(int m, int n, int[][] grid) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            HashMap<Integer, Integer> map = new HashMap<>(); // 원소의 갯수 저장

            for(int y = 0; y < grid.length; y++) {
                for(int x = 0; x < grid[0].length; x++) {
                    if(!map.containsKey(0)&& grid[y][x] == 0) map.put(0, 1);
                    if(v[y][x] == 0 && grid[y][x] != 0) { // 미방문 / 0이 아닌경우
                        front = 0; rear = 0;
                        v[y][x] = v[y][x]; // 방문표시
                        q[rear][0] = x;
                        q[rear][1] = y;
                        rear++;
                        bfs(map, grid);
                    }
                }
            }
            int cnt = 0, max = 0;
            Iterator<Integer> keys = map.keySet().iterator();
            while(keys.hasNext()) {
                cnt++;
                int intKey = keys.next();
                int intVal = map.get(intKey);
                if(max < intVal) max = intVal;
            }
            numberOfArea = cnt;
            maxSizeOfOneArea = max;

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        public void bfs(HashMap<Integer, Integer> map, int[][] grid) {
            int max = 0, cnt = 0;
            int x = q[front][0];
            int y = q[front][1];
            int keyIdx = grid[y][x];
            if(map.containsKey(keyIdx)) max = map.get(keyIdx);

            while(rear > front) {
                x = q[front][0];
                y = q[front][1];
                front++;

                for(int i = 0; i < 4; i++) {
                    if(y - dy[i] >= 0 && x - dx[i] >= 0 && x - dx[i] < grid[0].length && y - dy[i] < grid.length){
                        if(grid[y - dy[i]][x - dx[i]] == grid[y][x] && v[y - dy[i]][x - dx[i]] == 0) {
                            q[rear][0] = x - dx[i];
                            q[rear][1] = y - dy[i];
                            rear++;
                            v[y - dy[i]][x - dx[i]] = grid[y][x];
                            cnt++;
                        }
                    }
                }
            }
            if(cnt > max) map.put(keyIdx, cnt);
            if(!map.containsKey(keyIdx)) map.put(keyIdx, cnt);
        }
    }
}
