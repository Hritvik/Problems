package leetCode;

public class AddTwoNumbers_Solved {
	public static void main(String[] args) {
		AddTwoNumbers_Solved numbers = new AddTwoNumbers_Solved();
		numbers.driver();
	}

	void driver() {
//		ListNode l1 = new ListNode(5, new ListNode(6, new ListNode(4)));
//		ListNode l2 = new ListNode(7, new ListNode(0, new ListNode(8)));
		ListNode l1 = new ListNode(9, new ListNode(1, new ListNode(6)));
		ListNode l2 = new ListNode(0);
		ListNode result = addTwoNumbers(l1, l2);
		System.out.print("result = ");
		while (result != null) {
			System.out.print(result.val);
			result = result.next;
		}
		System.out.println();
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode a = l1;
		ListNode b = l2;
		ListNode iter = new ListNode(0);
		ListNode result = iter;
		int carry = 0;
		while (a != null || b != null || carry == 1) {
			if (a != null) {
//				System.out.println("a = " + a.val);
				iter.val += a.val;
			}
			if (b != null) {
//				System.out.println("b = " + b.val);
				iter.val += b.val;
			}
//			System.out.println("carry = " + carry);
			iter.val += carry;
			carry = 0;
			if (iter.val > 9) {
				iter.val -= 10;
				carry = 1;
			}
//			System.out.println("result = " + iter.val + " :: carry = " + carry);

			if (a != null) {
				a = a.next;
			}
			if (b != null) {
				b = b.next;
			}
			if (a != null || b != null || carry == 1) {
				iter.next = new ListNode(0);
			}
			iter = iter.next;
		}
		return result;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
