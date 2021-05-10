package com.leetcode.backtracking;

import java.util.ArrayList;

public class PathwithMaximumGold1219 {
    public int maxX = 0;
    public int maxY = 0;
    public int maxVal = 0;

    public int getMaximumGold(int[][] grid) {
        maxX = grid[0].length;
        maxY = grid.length;
        /*
            1. 모든 위치에서 시작(0으론 이동 x)
            2. 재귀로 처리
            3. 가장 큰 max 값을 가진 경로를 arrayList에 저장
        */
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Integer> tempPath = new ArrayList<>();

        for(int y = 0; y < maxY; y++) { // 0이 아닌 포인트를 우선 찾음
            for(int x = 0; x < maxX; x++) {
                if(grid[y][x] == 0) continue;
                tempPath = findMax(x, y, grid, new ArrayList<>(), new boolean[maxY][maxX]);
                // System.out.println("temp " + tempPath);
                if(tempPath.stream().mapToInt(Integer::intValue).sum() > path.stream().mapToInt(Integer::intValue).sum()) path = tempPath;
            }
        }



        return path.stream().mapToInt(Integer::intValue).sum();
    }
    public ArrayList<Integer> findMax(int x, int y, int[][] grid, ArrayList<Integer> path, boolean[][] visited) { // 최종 path를 리턴 한다
        if(grid[y][x] == 0 || visited[y][x]) {
            return path;
        }

        visited[y][x] = true;
        path.add(grid[y][x]);

        if(x + 1 < maxX && grid[y][x + 1] != 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp = findMax(x + 1, y, grid, path, visited);

            if(path.stream().mapToInt(Integer::intValue).sum() < temp.stream().mapToInt(Integer::intValue).sum()) path = temp;
        }
        if(y - 1 >= 0 && grid[y - 1][x] != 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            findMax(x, y - 1, grid, path, visited);

            if(path.stream().mapToInt(Integer::intValue).sum() < temp.stream().mapToInt(Integer::intValue).sum()) path = temp;
        }
        if(x - 1 >= 0 && grid[y][x - 1] != 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            findMax(x - 1, y, grid, path, visited);

            if(path.stream().mapToInt(Integer::intValue).sum() < temp.stream().mapToInt(Integer::intValue).sum()) path = temp;
        }
        if(y + 1 < maxY && grid[y + 1][x] != 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp = findMax(x, y + 1, grid, path, visited);

            if(path.stream().mapToInt(Integer::intValue).sum() < temp.stream().mapToInt(Integer::intValue).sum()) path = temp;
        }
        // System.out.println("max: " + path);
        return path;
    }
}
