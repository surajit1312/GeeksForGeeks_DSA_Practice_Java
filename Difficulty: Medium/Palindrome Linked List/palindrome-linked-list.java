//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            boolean f = new Solution().isPalindrome(head);

            System.out.println(f ? "true" : "false");
        }
    }
}

// } Driver Code Ends


/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    private boolean isOdd = false;
    
    // Function to check whether the list is palindrome.
    /**
     * TC: O(3N / 2) ~ O(N)
     * SC: O(1)
     */
    boolean isPalindrome(Node head) {
        Node mid = middleLL(head); // TC: O(N/2)
        if (isOdd) {
            mid = mid.next;
        }
        Node reverse = reverseLL(mid); // TC: O(N/2)
        Node current = head;
        Node revCurrent = reverse;
        while (current != null && revCurrent != null) { // TC: O(N/2)
            if (revCurrent.data != current.data) {
                return false;
            }
            current = current.next;
            revCurrent = revCurrent.next;
        }
        return true;
    }
    
    private Node reverseLL(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
    
    private Node middleLL(Node head) {
        Node slow = head;
        Node fast = head;
        int count = 1;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        isOdd = count % 2 == 1;
        return slow;
    }
}