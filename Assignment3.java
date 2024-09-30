import java.util.Scanner;

public class Assignment3 {

    static class Song{
        String title;
        String artist;
        Song next;
        Song(String t,String a){
            title=t;
            artist=a;
            next=null;
        }
    }

    static class PlayList{
        Song head=null;

        void addSong(String t,String a){
            Song nSong=new Song(t, a);
            if(head==null){
                head=nSong;
                return;
            }
            Song temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=nSong;
        }

        void removeSong(String t){
            if(head==null){
                System.out.println("PlayList is Empty!");
                return ;
            }
            if(head.next==null){
                head=null;
                return ;
            }
            Song temp=head;
            while(temp!=null && !temp.next.title.equals(t)){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }

        void displayList(){
            if(head==null){
                System.out.println("PlayList is Empty!");
                return;
            }
            Song temp=head;
            while(temp!=null){
                System.out.println("Title:"+temp.title+" "+"Artist:"+temp.artist);
                temp=temp.next;
            }
            System.out.println("Your List Ends Here");
        }

        void searchSong(String t){
            if(head==null){
                System.out.println("PlayList is Empty!");
                return;
            }
            
            Song temp=head;
            while(temp!=null){
                if(temp.title.equals(t)){
                    System.out.println("Title:"+temp.title+" "+"Artist:"+temp.artist);
                    return ;
                }
                temp=temp.next;
            }
            System.out.println("Song is not Available in your playlist");
        }

    }

    public static void main(String[] args) {
        PlayList pl=new PlayList();
        Scanner sc=new Scanner(System.in);
        int choice=0;

        while(choice!=5){
            System.out.println("1. ADD NEW SONG");
            System.out.println("2. DELETE SONG IN PLAYLIST");
            System.out.println("3. DISPLAY FULL LIST");
            System.out.println("4. SEARCH A SONG IN PLAYLIST");
            System.out.println("5. EXIT");
            
            choice=sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of Song:");
                    String t=sc.nextLine();
                    t=sc.nextLine();
                    System.out.println("Enter the name of artist");
                    String a=sc.nextLine();
                    // a=sc.nextLine();
                    pl.addSong(t, a);
                    break;
                
                case 2:
                    System.out.println("Enter Song name to Delete it:");
                    String d=sc.nextLine();
                    d=sc.nextLine();
                    
                    pl.removeSong(d);
                    break;

                case 3:
                    System.out.println("Your PlayList is:");
                    pl.displayList();
                    break;
                case 4:
                    System.out.println("Enter song to Search:");
                    String s=sc.nextLine();
    
                    pl.searchSong(s);
                    break;
                default:
                    System.out.println("Exiting...");
                    break;
            }

        }
        sc.close();
    }
}
