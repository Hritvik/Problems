package leetCode;

public class ReverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode[] arr = new ListNode[k];
		ListNode output = null;
		boolean breakflag = false;
		while (head != null) {
			for (int i = 0; i < k; i++) {
				arr[i] = head;
				if (head.next != null) {
					head = head.next;
				} else {
//					breakFlag = true;
					break;
				}

			}
			if (breakflag) {
				break;
			} else {
				// swap
			}

		}
		return output;
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
