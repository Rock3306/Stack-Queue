package com.common;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 * 		思路：将 1、2、3 一次放入队列一，然后最上面的 3 留在队列一，
 * 将下面的 2、3 入队列二，把 3 出队列一，此时队列一空了，然后把队列二中的所有数据
 * 入队列一；将最上面的 2 留在队列一，将下面的 3 入队列二。。一次循环
 * @author rocki
 *
 */
public class TwoQueueForStack {
	
	Queue<Integer> queue1 = new ArrayDeque<Integer>();
	Queue<Integer> queue2 = new ArrayDeque<Integer>();
	
	// 方法：入栈操作
	public void push(int data) {
		queue1.add(data);
	}
	
	// 方法：出栈操作
	public int pop() throws Exception{
		int data;
		if (queue1.size() == 0) {
			throw new Exception("栈为空");
		}
		
		while (queue1.size() != 0) {
			if (queue1.size() == 1) {
				data = queue1.poll();// 取队列中第一位元素
				while (queue2.size() != 0) {
					// 把queue2中的全部数据放到队列一中
					queue1.add(queue2.poll());
				}
				return data;
			}
			queue2.add(queue1.poll());
		}
		throw new Exception("栈为空");
	}
	
	public static void main(String[] args) throws Exception {
		TwoQueueForStack stack = new TwoQueueForStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(4);
	}
}
