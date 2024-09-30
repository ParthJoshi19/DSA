import java.util.Scanner;

public class Assignment4 {

    static class Text {
        String data;
        Text next;
        Text prev;

        Text(String s) {
            data = s;
            next = null;
            prev = null;
        }
    }

    static class Editor {
        Text head = null;

        void insert(String s) {
            Text nn = new Text(s);
            if (head == null) {
                head = nn;
                return;
            }
            Text temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nn;
            nn.prev = temp;
        }

        void delete(String s) {
            if (head == null) {
                return;
            }
            Text temp = head;
            while (temp != null) {
                String[] arr = temp.data.split(" ");
                String x = "";
                for (String str : arr) {
                    if (str.equals(s)) {
                        continue;
                    }
                    x += " " + str;
                }
                temp.data = x.trim().isEmpty() ? temp.data : x.trim();
                temp = temp.next;
            }
        }

        void display() {
            if (head == null) {
                return;
            }
            Text temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        void search(String word) {
            if (head == null) {
                return;
            }
            Text temp = head;
            boolean found = false;
            while (temp != null) {
                if (temp.data.contains(word)) {
                    System.out.println("Word found in: " + temp.data);
                    found = true;
                }
                temp = temp.next;
            }
            if (!found) {
                System.out.println("Word not found.");
            }
        }

        void printRev() {
            if (head == null) {
                return;
            }
            Text temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Editor editor = new Editor();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nText Editor Menu:");
            System.out.println("1. Insert text");
            System.out.println("2. Delete text");
            System.out.println("3. Display text");
            System.out.println("4. Search text");
            System.out.println("5. Print text in reverse");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter text to insert:");
                    String text = sc.nextLine();
                    editor.insert(text);
                    break;
                case 2:
                    System.out.println("Enter word to delete:");
                    String wordToDelete = sc.nextLine();
                    editor.delete(wordToDelete);
                    break;
                case 3:
                    System.out.println("Current text:");
                    editor.display();
                    break;
                case 4:
                    System.out.println("Enter word to search:");
                    String wordToSearch = sc.nextLine();
                    editor.search(wordToSearch);
                    break;
                case 5:
                    System.out.println("Text in reverse:");
                    editor.printRev();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
