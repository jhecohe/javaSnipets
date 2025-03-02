public class InsertNode {

    public static SinglyLinkedListNode insertNodeAtPosition(
        SinglyLinkedListNode llist,
        int data,
        int position
    ) {
        // Write your code here
        if (llist == null) {
            return llist;
        }

        SinglyLinkedListNode current = llist;

        int count = 1;
        while (current.next != null) {
            System.out.println(count);
            if (count == position) {
                SinglyLinkedListNode aux = current.next;
                current.next = new SinglyLinkedListNode(data);
                current.next.next = aux;
                break;
            }
            count++;
            current = current.next;
        }

        return current;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode n1 = new SinglyLinkedListNode(16);
        SinglyLinkedListNode n2 = new SinglyLinkedListNode(13);
        SinglyLinkedListNode n3 = new SinglyLinkedListNode(7);

        n1.next = n2;
        n2.next = n3;

        insertNodeAtPosition(n1, 1, 2);
        print(n1);
    }

    public static void print(SinglyLinkedListNode head) {
        if (head == null) {
            System.out.println("END");
            return;
        }
        SinglyLinkedListNode current = head;
        while (current.next != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println(current.data + " -> END");
    }
}
