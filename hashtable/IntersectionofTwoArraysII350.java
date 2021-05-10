package com.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArraysII350 {
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1.length == 0 || nums2.length == 0) return new int[0];

		List<Integer> listRes = new ArrayList<>();
		int idx = 0;

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		if(nums1.length < nums2.length) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}

		for(int i = 0; i < nums1.length;) {
			if(nums1[i] == nums2[idx]) {
				listRes.add(nums1[i]);
				idx++;
				i++;
			} else { // 같지 않을 경우 비교군 index(idx)를 +할지 판단
				if(nums1[i] > nums2[idx]) idx++;
				else i++;
			}
			if(idx >= nums2.length || idx >= nums1.length) break;
		}
		int[] res = new int[listRes.size()];
		idx = 0;
		for(int val: listRes) {
			res[idx++] = val;
		}


		return res;
	}
}
