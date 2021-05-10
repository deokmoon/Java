package com.leetcode.tree.common;

import java.util.List;

/**
 * 이 클래스는 dfs bfs 관련 클래스이다.
 * <br>  - graph(array) 초기화 및 생성 가능
 * <br>  - dfs/bfs 탐색 결과 받을 수 있음
 * @version 1.0
 * @author deokmoon / deok2moon@gmail.com
 */
public class DfsAndBfs {
	/**
	 * 그래프 생성 및 초기화 처리 메소드
	 * <br></>n의 크기만큼 2차원 배열을 생성 후 0으로 초기화
	 * @Params n (배열의 크기)
	 */
	public int[][] initGraph(int n ) {
		int[][] graph = new int[n][n];

		return graph;
	}

	/**
	 * 그래프 값 입력 메소드
	 * @Params graph, col, row, val
	 */
	public int[][] setGraphValue(int[][] graph, int col, int row, int val) {
		graph[col][row] = val;

		return graph;
	}
	/**
	 * 그래프 값 입력 메소드
	 * @Params graph, start, end
	 */
	public List<Integer> depthFirstSearch(int[][] graph, List<Integer> visited, int start) {

		return null;
	}
}
