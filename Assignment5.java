import java.util.Scanner;

class Route {
    String route;
    Route next;

    Route() {
        route = "";
        next = null;
    }

    Route(String s) {
        route = s;
        next = null;
    }
}

class Navigator {
    Route head;

    Navigator() {
        head = null;
    }

    void addRouteStart(String s) {
        Route newRoute = new Route(s);
        if (head == null) {
            head = newRoute;
            head.next = head;
            return;
        }
        Route temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newRoute;
        newRoute.next = head;
        head = newRoute;
    }

    void addRouteEnd(String s) {
        Route newRoute = new Route(s);
        if (head == null) {
            head = newRoute;
            head.next = head;
            return;
        }
        Route temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newRoute;
        newRoute.next = head;
    }

    void addRouteBetween(String s, int pos) {
        if (pos == 0) {
            addRouteStart(s);
            return;
        }
        Route newRoute = new Route(s);
        Route temp = head;
        int currPos = 0;
        while (currPos < pos - 1 && temp.next != head) {
            temp = temp.next;
            currPos++;
        }
        if (currPos != pos - 1) {
            System.out.println("Position out of range.");
            return;
        }
        newRoute.next = temp.next;
        temp.next = newRoute;
    }

    void deleteRouteStart() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Route temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        head = head.next;
        temp.next = head;
    }

    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Route temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        temp.next = head;
    }

    void deleteBetween(int pos) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (pos == 0) {
            deleteRouteStart();
            return;
        }
        Route temp = head;
        int currPos = 0;
        while (currPos < pos - 1 && temp.next != head) {
            temp = temp.next;
            currPos++;
        }
        if (temp.next == head || currPos != pos - 1) {
            System.out.println("Position out of range.");
            return;
        }
        temp.next = temp.next.next;
    }

    void print() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Route temp = head;
        do {
            System.out.print(temp.route + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Navigator list = new Navigator();
        int choice;

        do {
            System.out.println("\n1. Add route at the start");
            System.out.println("2. Add route at the end");
            System.out.println("3. Add route in between the linked list");
            System.out.println("4. Delete a route at start");
            System.out.println("5. Delete a route in between");
            System.out.println("6. Delete route at the end");
            System.out.println("7. Print Routes");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the route you want to insert at the start: ");
                    String startRoute = sc.nextLine();
                    list.addRouteStart(startRoute);
                    break;
                case 2:
                    System.out.print("Enter the route you want to insert at the end: ");
                    String endRoute = sc.nextLine();
                    list.addRouteEnd(endRoute);
                    break;
                case 3:
                    System.out.print("Enter the position at which you want to insert the route: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the route you want to insert: ");
                    String betweenRoute = sc.nextLine();
                    list.addRouteBetween(betweenRoute, pos);
                    break;
                case 4:
                    list.deleteRouteStart();
                    break;
                case 5:
                    System.out.print("Enter the position of the route you want to delete: ");
                    int delPos = sc.nextInt();
                    list.deleteBetween(delPos);
                    break;
                case 6:
                    list.deleteEnd();
                    break;
                case 7:
                    list.print();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 8);
        sc.close();
    }
}
