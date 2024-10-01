import java.util.Scanner;

public class Assignment2 {
    static class Employee {
        String name;
        int id;
        int salary;

        public Employee(String name, int id, int salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        void getData() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Name of Employee: ");
            name = sc.next();
            System.out.print("Enter ID of Employee: ");
            id = sc.nextInt();
            System.out.print("Enter Salary of Employee: ");
            salary = sc.nextInt();
            System.out.println();
        }

        void displayData() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Salary: " + salary);
            System.out.println();
        }
    }

    static void quickSort(Employee[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Employee[] arr, int low, int high) {
        int pivot = arr[high].id;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].id < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(Employee[] arr, int i, int j) {
        Employee temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void merge(Employee[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Employee[] L = new Employee[n1];
        Employee[] R = new Employee[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].name.compareTo(R[j].name) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(Employee[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[4];

        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Enter Employee Data");
            System.out.println("2. Sort Employees by ID (Quick Sort)");
            System.out.println("3. Sort Employees Alphabetically by Name (Merge Sort)");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < employees.length; i++) {
                        employees[i] = new Employee("", 0, 0);
                        employees[i].getData();
                    }
                    break;

                case 2:
                    quickSort(employees, 0, employees.length - 1);
                    System.out.println("Employees sorted by ID.");
                    break;

                case 3:
                    mergeSort(employees, 0, employees.length - 1);
                    System.out.println("Employees sorted alphabetically by name.");
                    break;

                case 4:
                    for (Employee emp : employees) {
                        emp.displayData();
                    }
                    break;

                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}
