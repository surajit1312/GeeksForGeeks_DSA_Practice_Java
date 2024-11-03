//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline character after t

        while (t-- > 0) {
            String input = sc.nextLine(); // Read the entire line for the array elements
            String[] values = input.split(" ");

            Node head = null, tail = null;
            for (String value : values) {
                int x = Integer.parseInt(value);
                if (head == null) {
                    head = new Node(x);
                    tail = head;
                } else {
                    tail.next = new Node(x);
                    tail.next.prev = tail;
                    tail = tail.next;
                }
            }

            int valueToInsert = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine(); // Ignore the newline character after the value
            }

            Solution obj = new Solution();
            head = obj.sortedInsert(head, valueToInsert);
            printList(head);
        
System.out.println("~");
}

        sc.close();
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public Node sortedInsert(Node head, int x) {
        if (head == null) {
            head = new Node(x);
            return head;
        }
        if (head.data >= x) {
            Node nxt = head;
            head = new Node(x);
            head.next = nxt;
            return head;
        }
        Node prev = null;
        Node curr = head;
        boolean isInserted = false;
        while (curr != null) {
            if (curr.data >= x && !isInserted) {
                prev.next = new Node(x);
                prev.next.next = curr;
                isInserted = true;
            }
            prev = curr;
            curr = curr.next;
        }
        if (!isInserted && prev.data < x) {
            prev.next = new Node(x);
        }
        return head;
    }
}