// import java.text.ListFormat.Style;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment7 {

    static class Stack{
        String arr[];
        int top;
        Stack(){
            top=-1;
            arr=new String[100];
        }
        Stack(String[] arr){
            this.arr=arr;
            top=-1;
        }

        void display(){
            for(int i=top;i>=0;i--){
                System.out.println(arr[i]);
            }
        }

        void addHistory(String s){
            top++;
            arr[top]=s;
        }

        void NavigateBack(){
            if(top>0)
                top--;
        }

        void viewCurr(){
            if(top!=-1)
                System.out.println(arr[top]);
        }

        void historyIsEmpty(){
            if(top==-1){
                System.out.println("No History found");
            }
            else{
                System.out.println("Enter 5 to see history");
            }
        }

    }

    public static void main(String[] args) {
        Stack st=new Stack();
        Scanner sc=new Scanner(System.in);
        int choice=0;
        while(choice!=6){
            System.out.println("1. Search Something to add it in History");
            System.out.println("2. Navigate Back");
            System.out.println("3. View Current Page");
            System.out.println("4. Check History");
            System.out.println("5. Display History");
            System.out.println("6. Exit");
            choice=sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Search here something:");
                    String str=sc.nextLine();
                    str=sc.nextLine();
                    st.addHistory(str);
                    break;
                case 2:
                    System.out.println("Your Remaining History is:");
                    st.NavigateBack();
                    st.display();
                    break;
                case 3:
                    System.out.println("Your current page is:");
                    st.viewCurr();
                    break;
                case (4):
                    System.out.println("Your History Status:");
                    st.historyIsEmpty();
                    break;
                case 5:
                    System.out.println("Your History:");
                    st.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
            }

        }
    }   
}
