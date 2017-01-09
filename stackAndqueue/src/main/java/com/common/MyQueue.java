package com.common;

/**
 * 通过链表方式创建队列
 * 
 * @author rocki
 *
 */
public class MyQueue {
	
	public Node head;
	public Node current;
	
	// 方法：链表中添加节点
	public void add(int data) {
		if(head == null) {
			head = new Node(data);
			current = head;
		} else {
			current.next = new Node(data);
			current = current.next;
		}
	}
	
	// 方法：出队操作
	public int pop() throws Exception {
		if(head == null) {
			throw new Exception("队列为空");
		}
		
		Node node = head;// node节点就是我们要出队的节点
		head = head.next; // 出队之后,head 指针向下移
		
		return node.data;
	}
	
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) throws Exception {
		MyQueue queue = new MyQueue();
		// 入队操作
		for (int i = 0; i < 5; i++) {
			queue.add(i);
		}
		
		// 出队操作
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}
