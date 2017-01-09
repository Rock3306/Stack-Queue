package com.common;

/**
 * 通过链表形式创建栈
 * 
 * @author rocki
 *
 */
public class MyStack {
	
	public Node head;
	public Node current;
	
	//方法：入栈操作
	public void push(int data) {
		if (null == head){
			head = new Node(data);
			current = head;
		} else {
			Node node = new Node(data);
			node.pre = current; // current 节点将作为当前节点的前驱节点
			current = node; // 让 current 节点永远指向新添加的那个节点
		}
	}
	
	// 方法：出栈
	public Node pop() {
		if(current == null) {
			return null;
		}
		
		Node node = current;// current 节点是我们要出栈的节点
		current = current.pre; // 每出栈一个节点后，current 后退一位
		return node;
	}

	class Node {
		int data;
		Node pre;// 我们需要知道当前节点的前一个节点
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.pop().data);
		System.out.println(stack.pop().data);
		System.out.println(stack.pop().data);
	}
}
