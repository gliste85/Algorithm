import java.util.*;

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
  private class doubleList {
    int key;
    int val;
    doubleList prev;
    doubleList next;
    public doubleList(int key, int val) {
      this.key = key;
      this.val = val;
      prev = null;
      prev = next;
    }
  }

  doubleList head;
  doubleList tail;

  public Solution(int capacity) {
    head = new doubleList(-1, 0);
    tail = new doubleList(-1, capacity);
  }

  public int get(int key) {
    if (head.val == 0) {
      return -1;
    }
    doubleList curt = tail;
    while (tail.prev != head) {
      if (curt.prev.key == key) {
        if (curt.prev.next != tail) {
          doubleList temp = curt.prev;
          curt.prev = curt.prev.prev;
          curt.prev.next = curt;
          temp.prev = tail.prev;
          temp.next = tail;
          tail.prev.next = temp;
          tail.prev = temp;
        }
        return tail.prev.val;
      }
      curt = curt.prev;
    }
    return -1;
  }

  public void set(int key, int value) {
    if (head.val == 0) {
      head.next = new doubleList(key, value);
      head.next.prev = head;
      head.next.next = tail;
      tail.prev = head.next;
      head.val++;
      return;
    }

    int v = get(key);
    if (v != -1) {
      tail.prev.val = value;
    } else {
      if (head.val == tail.val) {
        deleteLeast();
        insertRecent(key, value);
      } else {
        insertRecent(key, value);
      }
    }
  }

  private void insertRecent(int key, int val) {
    doubleList temp = new doubleList(key, val);
    temp.prev = tail.prev;
    temp.next = tail;
    tail.prev.next = temp;
    tail.prev = temp;
    head.val++;
  }

  private void deleteLeast() {
    head.next = head.next.next;
    head.next.prev = head;
    head.val--;
  }






  public static void main(String[] args) {
    Set<String> dict = new HashSet<String>();
    dict.add("hot");
    dict.add("cog");
    dict.add("dog");
    dict.add("tot");
    dict.add("hog");
    dict.add("hop");
    dict.add("pot");
    dict.add("dot");
    int[] A = {1, 2, 3, 4, 5};
    int[] result = new temp().medianII(A);
    System.out.println(result);
  }
}

