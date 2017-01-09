package com.common;

import java.util.Stack;

/**
 * 设计含最小函数 min() 的栈，要求 min、push、pop 的时间复杂度都是o(1),
 * min 方法的作用是：返回栈中最小的值
 * 	普通思路：
 * 		一般情况下，我们可能会这么想：利用 min 变量，每次添加元素时，都和 min 元素做比较，
 * 这样的话，就能保证 min 存放的是最小值。但是这样的话，会存在一个问题：如果最小的元素出栈了，那么怎么知道
 * 剩下的元素中哪个是最小的元素呢？
 * 
 * 	改进思路：
 * 		这里需要增加一个辅助栈，用空间换取时间。辅助栈中，栈顶永远保存着最小的数值。
 * 具体是这样的：原栈中，每次添加一个新元素时，就和辅助栈的栈顶元素相比较，如果新元素小，
 * 就把新元素的值放到辅助栈中，如果新元素大，就把辅助栈中的栈顶元素再 copy 一遍放到辅助栈顶；
 * 		
 * @author rocki
 *
 */
public class MinStack {
	
	private Stack<Integer> stack = new Stack<Integer>();
	// 辅助栈：栈顶永远保存 stack 中当前的最小的元素
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int data) {
		stack.push(data);// 直接往栈中添加数据
		
		// 再辅助栈中需要做判断
		if (minStack.size() == 0 || data < minStack.peek()) {
			minStack.push(data);
		}else{
			minStack.add(minStack.peek());// 【核心代码】peek方法返回是栈顶的元素，元素不出栈
		}
	}
	
	public int pop() throws Exception {
		if (stack.size() == 0) {
			throw new Exception("栈中为空");
		}
		int data = stack.pop();
		minStack.pop();// 核心代码
		return data;
	}
	
	public int min() throws Exception {
		if (minStack.size() == 0) {
			throw new Exception("栈中为空");
		}
		return minStack.peek();
	}
	
	public static void main(String[] args) throws Exception {
		MinStack minStack = new MinStack();
		minStack.push(1);
		minStack.push(2);
		minStack.push(3);
		
		System.out.println(minStack.pop());
		System.out.println(minStack.pop());
		System.out.println(minStack.min());
	}
}
