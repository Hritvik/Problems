import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stackQueue {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			stack.add(i);
			queue.add(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(stack.pop()+" :: "+queue.poll());
		}
	}
}
