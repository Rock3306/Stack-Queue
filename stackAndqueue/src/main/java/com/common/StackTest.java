package com.common;

import java.util.Stack;

/**
 * 判定栈的push和pop顺序是否一致：
 * 	通俗一点讲：已知一组数据1、2、3、4、5一次进栈，那么它的出栈方式有很多种，
 * 请判断一下给出的出栈方式是否正确的？
 * 例如：
 * 数据：
 * 1、2、3、4、5
 * 出栈1:
 * 5、4、3、2、1（正确）
 * 出栈2:
 * 4、5、3、2、1（正确）
 * 出栈3:
 * 4、3、5、1、2（错误）
 * @author rocki
 *
 */
public class StackTest {
	
	// 方法：data1数组的顺序表示入栈的顺序。现在判断data2的这种出栈顺序是否正确
	public static boolean sequenseIsPop(int[] data1,int[] data2){
		Stack<Integer> stack = new Stack<Integer>();// 这里需要用到辅助栈
		
		for (int i = 0,j = 0; i < data1.length; i++) {
			stack.push(data1[i]);
			
			while (stack.size() > 0 && stack.peek() == data2[j]) {
				stack.pop();
				j++;
			}
		}
		return stack.size() == 0;
	}
	
	public static void main(String[] args) {
		int[] data1 = {1,2,3,4,5};
		int[] data2 = {4,5,3,2,1};
		int[] data3 = {4,5,2,3,1};
		
		System.out.println(sequenseIsPop(data1, data2));
		System.out.println(sequenseIsPop(data1, data3));
	}
}
