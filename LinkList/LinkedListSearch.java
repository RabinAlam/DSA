import java.util.Scanner;

// Node class representing a single node in the linked list
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Linked List class with search functionality
class LinkedList {
    Node head;

    // Add a node at the end of the list
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a key and return its position (1-based indexing)
    public int searchNode(int key) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == key) {
                System.out.printf("Key %d found at position %d%n", key, position);
                return position;
            }
            current = current.next;
            position++;
        }

        System.out.printf("Key %d not found in the list%n", key);
        return -1;
    }

    // Alternative method to return the Node reference
    public Node searchNodeReference(int key) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == key) {
                System.out.printf("Key %d found at position %d%n", key, position);
                return current;
            }
            current = current.next;
            position++;
        }

        System.out.printf("Key %d not found in the list%n", key);
        return null;
    }

    // Display the linked list using StringBuilder for efficiency
    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        StringBuilder sb = new StringBuilder("Linked List: ");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append(" -> NULL");
        System.out.println(sb);
    }

    // Get the length of the linked list
    public int getLength() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}

// Main class to test the linked list search functionality
public class LinkedListSearch {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Linked List Search Algorithm ===");

            // Create a sample linked list: 10 -> 25 -> 42 -> 15 -> 30
            int[] initialData = {10, 25, 42, 15, 30};
            for (int data : initialData) {
                list.addNode(data);
            }

            // Display the initial list
            list.display();
            System.out.println("List length: " + list.getLength() + "\n");

            // Test cases for search
            System.out.println("=== Testing Search Algorithm ===");
            int[] testKeys = {42, 10, 30, 99, 25};
            for (int i = 0; i < testKeys.length; i++) {
                System.out.printf("Test %d - Search for %d:%n", i + 1, testKeys[i]);
                if (i == 4) { // Add duplicate value before testing 25
                    list.addNode(25);
                    System.out.println("After adding duplicate value 25:");
                    list.display();
                }
                int result = list.searchNode(testKeys[i]);
                System.out.println("Returned: " + result + (i == 4 ? " (first occurrence)" : "") + "\n");
            }

            // Test returning Node reference
            System.out.println("=== Testing Node Reference Search ===");
            System.out.println("Search for 15:");
            Node foundNode = list.searchNodeReference(15);
            if (foundNode != null) {
                System.out.println("Node found with data: " + foundNode.data);
                System.out.println("Next node data: " + (foundNode.next != null ? foundNode.next.data : "NULL"));
            }
            System.out.println();

            // Test empty list
            System.out.println("=== Testing Empty List ===");
            LinkedList emptyList = new LinkedList();
            emptyList.display();
            emptyList.searchNode(5);
            System.out.println();

            // Test user input
            System.out.println("=== Testing User Input ===");
            System.out.print("Enter the number of nodes: ");
            int nodeCount = scanner.nextInt();
            while (nodeCount < 0) {
                System.out.println("Please enter a non-negative number.");
                System.out.print("Enter the number of nodes: ");
                nodeCount = scanner.nextInt();
            }

            for (int i = 1; i <= nodeCount; i++) {
                System.out.print("Enter data for node " + i + ": ");
                int data = scanner.nextInt();
                list.addNode(data);
            }

            System.out.println("Updated Linked List:");
            list.display();

            System.out.print("Enter key to search: ");
            int key = scanner.nextInt();
            list.searchNode(key);
        }
    }
}