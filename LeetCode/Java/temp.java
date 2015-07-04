/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class temp {
  /**
   * @param head: The head of linked list.
   * @return: The new head of reversed linked list.
   */
  public static ListNode deleteDuplicates(ListNode head) {
    // write your code here
    ListNode dummy = new ListNode(0);
    ListNode preD = null;
    ListNode cur = dummy;
    while (head != null) {
      if (preD != null && head.val == preD.val) {
        head = head.next;
      } else if (head.next != null && head.val == head.next.val) {
        preD = head;
        head = head.next.next;
      } else {
        cur.next = head;
        cur = cur.next;
        head = head.next;
      }
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode test = new ListNode(0);
    test.next = new ListNode(1);
    test.next.next = new ListNode(2);
    test.next.next.next = new ListNode(2);
    test.next.next.next.next = new ListNode(2);
    ListNode result = new temp().deleteDuplicates(test);
    return;
  }
}

