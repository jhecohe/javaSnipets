import java.util.HashSet;

/**
 * LinkedListCycle
 */
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode current = head;
        HashSet<Integer> visited = new HashSet<>();
        while (current != null) {
            System.out.println(current.val);
            if (visited.add(current.val) == true) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
/**
 * https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150
 */
