import java.util.Scanner;

class Nodex {
	int data;
	Nodex next;

	Nodex(int d) {
		data = d;
		next = null;
	}
}

public class ReorderList {
	Nodex head; // head of lisl

	/* Linked list Nodex */

	/* Utility functions */

	/* Inserts a new Nodex at front of the list. */
	public void addToTheLast(Nodex Nodex) {
		if (head == null) {
			head = Nodex;
		} else {
			Nodex temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = Nodex;
		}
	}

	/* Function to print linked list */
	void printList() {
		Nodex temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			ReorderList llist = new ReorderList();
			int a1 = sc.nextInt();
			Nodex head = new Nodex(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Nodex(a));
			}

			llist.head = new gsfg().reorderlist(llist.head);

			llist.printList();

			t--;
		}
	}
}
/*
 * This is a function problem.You only need to complete the function given below
 */
/* Following is the Linked list Nodex structure */
/*
 * class Nodex { int data; Nodex next; Nodex(int d) { data = d; next = null; } }
 */

class gsfg {
	Nodex reorderlist(Nodex head) {
		Nodex curr = head;
		while (curr!=null) {
			Nodex end = findEndNodex(curr);
			System.out.println(curr.data + " :: " + end.data);
			if (end == curr) {
				break;
			}
			end.next = curr.next;
			curr.next = end;
			curr = end.next;
		}
		return head;
	}

	Nodex findEndNodex(Nodex head) {
		Nodex prev = null;
		while (head.next != null) {
			prev = head;
			head = head.next;
		}
	if(prev!=null) {
		prev.next = null;
	}
		return head;
	}
}
