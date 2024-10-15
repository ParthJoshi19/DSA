import java.util.Scanner;

public class Assignment9B {

    static class Node {
        int customerId;
        Node next;

        Node(int id) {
            this.customerId = id;
            this.next = null;
        }
    }

    static class CircularQueue {
        Node f = null, r = null;

        void customerArrival(int customerId) {
            Node newNode = new Node(customerId);
            if (f == null) {  
                f = r = newNode;
                r.next = f; 
            } else {
                r.next = newNode;
                newNode.next = f;
                r = newNode;
            }
            System.out.println("Customer " + customerId + " has arrived.");
        }

        void customerCheckout() {
            if (f == null) { 
                System.out.println("No customers in the queue.");
                return;
            }

            int customerId = f.customerId;
            if (f == r) { 
                f = r = null;
            } else {
                f = f.next;
                r.next = f; 
            }
            System.out.println("Customer " + customerId + " has checked out.");
        }

        void closeCheckoutCounter() {
            if (f == null) {
                System.out.println("The queue is already empty.");
            } else {
                f = r = null;
                System.out.println("Checkout counter closed, all customers cleared.");
            }
        }

        void viewCustomers() {
            if (f == null) {
                System.out.println("No customers in the queue.");
                return;
            }

            Node temp = f;
            System.out.println("Customers in the queue:");
            do {
                System.out.println("Customer ID: " + temp.customerId);
                temp = temp.next;
            } while (temp != f);
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSupermarket Checkout System");
            System.out.println("1. Customer Arrival");
            System.out.println("2. Customer Checkout");
            System.out.println("3. Close Checkout Counter");
            System.out.println("4. View Customers");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    queue.customerArrival(customerId);
                    break;

                case 2:
                    queue.customerCheckout();
                    break;

                case 3:
                    queue.closeCheckoutCounter();
                    break;

                case 4:
                    queue.viewCustomers();
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        scanner.close();
    }
}
