package web_group3;

import java.util.PriorityQueue;

public class KeywordHeap{
	private PriorityQueue<Keyword> heap;
	
	public KeywordHeap() {
		this.heap = new PriorityQueue<Keyword>(10, new KeywordComparator());
	}
	
	public void add (Keyword k) {
		heap.offer(k);
		//System.err.println("Done");
	}
	
	public void peek() {
		if (heap.peek() == null) {
			System.out.println("InvalidPreration");
			return;
		}
		
		Keyword k = heap.peek();
		System.out.println(k.toString());
	}
	
	public void removeMin() {
		Keyword k = heap.poll();
		System.out.println(k.toString());
	}
	
	public void output() {
		// TODO:PRINT AND REMOVE ALL
		//USE POLL()
		if (heap.size() == 0 ) {
			System.out.println("Invalid");
		}else {
			while (heap.size()>0) {
				Keyword k = heap.poll();
				System.out.println(k.toString());
			}
		}
	}	
}