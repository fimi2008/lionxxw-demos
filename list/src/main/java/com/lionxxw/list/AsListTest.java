package com.lionxxw.list;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

public class AsListTest {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(new String[] { "a", "b" }));
 
        System.out.println(Arrays.asList(new Integer[] { 1, 2 }));
 
        System.out.println(Arrays.asList(new int[] { 1, 2 }));
 
        System.out.println(Arrays.asList(new String[] { "a", "b" }, "c"));
        
        System.out.println(Arrays.asList(ArrayUtils.toObject(new int[] { 1, 2 }) ));
        
	}
}
