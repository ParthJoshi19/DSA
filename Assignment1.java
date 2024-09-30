import java.util.Scanner;

public class Assignment1 {

    public static class student {

        String name;
        String prn;
        int id;

        public student(String name, String prn, int id) {
            this.name = name;
            this.prn = prn;
            this.id = id;
        }

        public void getData() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Name:");
            this.name = sc.nextLine();
            System.out.print("Enter PRN:");
            this.prn = sc.nextLine();
            System.out.print("Enter ID:");
            this.id = sc.nextInt();
            // sc.close();
        }

        public void display() {
            System.out.println("Name: " + name);
            System.out.println("PRN: " + prn);
            System.out.println("ID: " + id);
        }
    }

    public static void insertionSort(student s[], int n) {
        for (int i = 1; i < n; i++) {
            student val = s[i];
            int j = i - 1;
            while (j >= 0 && s[j].id > val.id) {
                s[j + 1] = s[j];
                j--;
            }
            s[j + 1] = val;
        }
    }

    public static void shellsort(student arr[]) {
        int n = arr.length;
        int intv = n / 2;
        for (int gap = intv; gap >= 1; gap /= 2) {
            for (int j = gap; j <= n - 1; j++) {
                for (int i = j - gap; i >= 0; i -= gap) {
                    if (arr[gap + i].id > arr[i].id) {
                        break;
                    } else {
                        student temp = arr[i + gap];
                        arr[gap + i] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }
    }

    public static void shellSort(student arr[]) {
        int n = arr.length;
        int intv = n / 2;
        for (int gap = intv; gap >= 1; gap /= 2) {
            for (int j = gap; j < n; j++) {
                for (int i = j - gap; i >= 0; i -= gap) {
                    if (arr[i + gap].id > arr[i].id) {
                        break;
                    } else {
                        student temp = arr[i + gap];
                        arr[i + gap] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }
    }

    static void driverCode() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("Enter number of students to add:");
        n = sc.nextInt();
        student students[] = new student[n];

        int choice = 0;
        do {
            System.out.println("1. Add Student:");
            System.out.println("2. Display Students:");
            System.out.println("3. Sort Students by ID (Shell Sort):");
            System.out.println("4. Sort Students by ID (Insertion Sort):");
            System.out.println("5. Exit:");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // last=n;
                    for (int i = 0; i < n; i++) {
                        students[i] = new student("", "", 0);
                    }
                    for (int i = 0; i < n; i++) {
                        students[i].getData();
                    }
                    break;
                case 2:
                    for (int i = 0; i < n; i++) {
                        students[i].display();
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Sorted Using Shell Sort:");
                    shellsort(students);
                    for (int i = 0; i < n; i++) {
                        students[i].display();
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Sorted Using Insertion Sort:");
                    insertionSort(students, n);
                    for (int i = 0; i < n; i++) {
                        students[i].display();
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Exit");
                    break;
                default:
                    break;
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        driverCode();
    }
}
