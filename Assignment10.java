import java.util.*;

class Job {
    int id;
    int priority;

    Job(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Job ID: " + id + ", Priority: " + priority;
    }
}

class Assignment10 {
    Deque<Job> dq = new ArrayDeque<>();
    Scanner sc = new Scanner(System.in);
    private void sortJobs() {
        if (dq.isEmpty()) {
            System.out.println("No jobs to sort.");
            return;
        }
        ArrayList<Job> jobList = new ArrayList<>(dq);
        Collections.sort(jobList, (j1, j2) -> j1.priority - j2.priority);
        dq.clear();

        for (Job j : jobList) {
            dq.add(j);
        }
    }
    void addJob() {
        System.out.print("Enter Job ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Job Priority: ");
        int priority = sc.nextInt();
        dq.addLast(new Job(id, priority));
        sortJobs();
        System.out.println("Job added successfully.");
    }

    void removeJob() {
        if (!dq.isEmpty()) {
            dq.removeFirst();
            System.out.println("Job removed successfully.");
        } else {
            System.out.println("No jobs to remove.");
        }
    }

    void displayJobs() {
        if (dq.isEmpty()) {
            System.out.println("No jobs available.");
        } else {
            for (Job j : dq) {
                System.out.println(j);
            }
        }
    }

    void searchJob() {
        System.out.print("Enter Job ID to search: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Job j : dq) {
            if (j.id == id) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Job found.");
        } else {
            System.out.println("Job not found.");
        }
    }

    public static void main(String[] args) {
        Assignment10 js = new Assignment10();
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nJob Scheduling System");
            System.out.println("1. Add Job");
            System.out.println("2. Remove Job");
            System.out.println("3. Display Jobs");
            System.out.println("4. Search Job");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    js.addJob();
                    break;
                case 2:
                    js.removeJob();
                    break;
                case 3:
                    js.displayJobs();
                    break;
                case 4:
                    js.searchJob();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
