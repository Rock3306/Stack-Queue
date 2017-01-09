package com.common;
import java.util.*;

/**
 * 两个栈实现一个队列
 * 		思路：栈 1 用于存储元素，栈 2 用于弹出元素，负负得正。
 * 
 * @author rocki
 *
 */
public class TwoStackForQueue {
	
	private Stack<Integer> stack1 = new Stack<Integer>();// 执行入队操作的栈
	private Stack<Integer> stack2 = new Stack<Integer>();// 执行出队操作的栈
	
	// 方法：给队列增加一个入列的操作
	public void push(int data) {
		stack1.push(data);
	}
	
	// 方法：给队列正价一个出队列的操作
	public int pop() throws Exception{
		
		/* 
			stack1中的数据放到stack2之前，先要保证stack2里面是空的(
			要么一开始就是空的，要么是stack2中的数据出完了),不然出队的顺序会乱的，
			这一点很容易忘
		*/	
		if (stack2.empty()) {
			while (!stack1.empty()) {
				// 把statck1中的数据出栈，放到stack2中【核心】
				stack2.push(stack1.pop());
			}
		}
		
		// stack2 为空时，有两种可能：1、一开始，两个栈的数据都是空的；2、stack2 中的数据出完了
		if (stack2.empty()) {
			throw new Exception("队列为空");
		}
		
		return stack2.pop();
	}
	
	public static void main(String[] args) throws Exception {
		TwoStackForQueue queue = new TwoStackForQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		
		System.out.println(queue.pop());
		
		queue.push(4);
		
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}
