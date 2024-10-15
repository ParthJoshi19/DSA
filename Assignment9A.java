import java.util.Scanner;

public class Assignment9A {

    static class Queue{
        String arr[]=new String[100];
        int f=-1;
        int r=-1;

        public void AddParty(String val){
            if(r==arr.length-1){
                System.out.println("Waiting List is full");
                return;
            }
            if(f==-1) f++;
            r++;
            arr[r]=val;
        }

        public void seatParty(){
            if(f==-1){
                System.out.println("Waiting List is Empty");
                return ;
            }
            String val=arr[f];
            f++;
            if(f>r){
                f=-1;
                r=-1;
            }
            System.out.println("Seated Party is:"+val);
        }

        public void displayWaitlist(){
            for(int i=f;i<=r;i++){
                System.out.println(arr[i]);
            }
        }

    }

    public static void main(String[] args) {
        Queue q=new Queue();
        Scanner sc=new Scanner(System.in);
        int choice=0;
        while(choice!=4){
            System.out.println("1. Add Party to Waitlist");
            System.out.println("2. Seat Party");
            System.out.println("3. Display waitlist");
            System.out.println("4. Exit...");

            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Party Name :");
                    String s=sc.nextLine();
                    s=sc.nextLine();
                    q.AddParty(s);
                    break;
                case 2:
                    q.seatParty();
                    break;
                case 3:
                    System.out.println("Waiting list is:");
                    q.displayWaitlist();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Please Enter right choice");
                    break ;
            }

        }
    }
}
