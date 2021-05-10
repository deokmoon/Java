package com.leetcode;

import com.leetcode.backtracking.PathwithMaximumGold1219;
import com.leetcode.backtracking.Permutations46;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
/*	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();

		//라인단위로 입력받기(Enter를 경계로)
	    String str = bf.readLine();

		//정수형 입력이라면, 형변환 필수!
	    int i = Integer.parseInt(bf.readLine());

		//Space를 경계로 끊어야 할 때
	    String arr[] = str.split(" ");
		//또는 StringTokenizer 클래스 이용)*/

	    int[] param = {-1, 0, 1,1,1,2, 0, 1, 0};
//	    CountofMatchesinTournament1688 input = new CountofMatchesinTournament1688();
//	    System.out.println(input.moveZeroes(param));
//	    input.numberOfMatches(7);
	    int n = 1, num = 26;
	    System.out.println(n>>>2);
	    System.out.printf("16진수 4비트: ");
	    System.out.println(n & 0xF);
	    StringBuffer sb = new StringBuffer();
//	    sb.append("1234");
//	    System.out.println(sb.toString());
//	    sb.append(5679);
//	    System.out.println(sb.toString());
		ArrayList<Integer> stack = new ArrayList<>();
		stack.add(1);
		stack.add(2);
		stack.remove(0);

		stack.stream().mapToInt(Integer::intValue).sum();



		System.out.println(stack);

		HashMap<String, Integer> map = new HashMap<>();

		map.put("{", 2);
		map.forEach((key, val) -> {
			if(val % 2 != 0) System.out.println("hello");
			else System.out.println("hi");
		});

		Permutations46 per = new Permutations46();
		int[] nums = {1, 2, 3};
		per.permute(nums);

		PathwithMaximumGold1219 back = new PathwithMaximumGold1219();
		int input[][] = {
				{1,0,7}
				,{2,0,6}
				,{3,4,5}
				,{0,3,0}
				,{9,0,20}
		};

		back.getMaximumGold(input);




    }
}
